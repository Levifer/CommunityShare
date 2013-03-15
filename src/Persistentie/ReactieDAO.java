/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistentie;


import Domein.Reactie;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arne
 */
public class ReactieDAO {
    
    //aanmaken van een reactie
    public void aanmakenVanEenReactie(Reactie r){
        Connectie connect = new Connectie();
        Statement statement;
        try{
            statement = connect.getConnection().createStatement();
            String sql=("INSERT INTO reactie( "
                    + "EventNr,"
                    + "GevaarNr,"
                    + "PersoonNr,"
                    + "Reactie "
                    + "Datum)"
                    + "VALUES(?,?,?,?,?)");
            
            PreparedStatement pstmt = connect.getConnection().prepareStatement(sql);
            pstmt.setInt(1,r.getEventNr());
            pstmt.setInt(2, r.getGevaarNr());
            pstmt.setInt(3,r.getPersoonNr());
            pstmt.setString(4,r.getReactie());
            pstmt.setDate(5, r.getDatum());
            
            pstmt.executeUpdate();
            connect.closeConnection();
        }  
             catch (SQLException sqlException) {
                        System.out.print("Database Error");
                        sqlException.getMessage();

			System.exit(1);
			}
        //reactie verwijderen
    }
    
    public void verwijderenVanEenReactie(Reactie r){
       Connectie connect = new Connectie();
         Statement statement;
        try{
            statement= connect.getConnection().createStatement();
            String sql= ("DELETE FROM reactie WHERE("
                    + "EventNr,"
                    + "GevaarNr,"
                    + "PersoonNr,"
                    + "Reactie )"
                    + "VALUES(?,?,?,?)");
            
            PreparedStatement pstmt = connect.getConnection().prepareStatement(sql);
             pstmt.setInt(1, r.getEventNr());
             pstmt.setInt(2, r.getGevaarNr());
             pstmt.setInt(3, r.getPersoonNr());
             pstmt.setString(4, r.getReactie());
             pstmt.executeUpdate();
             pstmt.close();
             connect.closeConnection();
            
        }   
       catch (SQLException sqlException) {
                        System.out.print("Database Error");
                        sqlException.getMessage();

			System.exit(1);
			}
     
     }
    
    //lijst/zoeken = meldingnr meegeven, moet lijst geven van die reactie op die melding
    public List<Reactie> geefLijstReactiesGevaar(int gevaarNr) 
	{
           List<Reactie> reactieLijstGevaar = new ArrayList<Reactie>();
           
           Connectie connect = new Connectie();
           Statement statement;
           try {
                  statement = connect.getConnection().createStatement();
                  ResultSet rs = statement.executeQuery("SELECT PersoonNr, Reactie FROM reactie WHERE "
                           + "GevaarNr = '"+gevaarNr+"' "
                           + "ORDER BY Datum");
                  
                  
                  
                  while(rs.next()){
                            Date datum=null;
                            int eventNr = 0;
                          Reactie re = new Reactie(eventNr,gevaarNr,rs.getInt("PersoonNr"), rs.getString("Reactie"),datum);
                          reactieLijstGevaar.add(re);
                  }
           }
           catch (SQLException e) 
		{
			e.printStackTrace();
		}
           return reactieLijstGevaar;

        }
        public List<Reactie> geefLijstReactiesEvent(int eventNr) 
	{
           List<Reactie> reactieLijstGevaar = new ArrayList<Reactie>();
           
           Connectie connect = new Connectie();
           Statement statement;
           try {
                  statement = connect.getConnection().createStatement();
                  ResultSet rs = statement.executeQuery("SELECT PersoonNr, Reactie FROM reactie WHERE "
                           + "EventNr = '"+eventNr+"' "
                           + "ORDER BY Datum");
                  
                  
                  
                  while(rs.next()){
                            Date datum=null;
                            int gevaarNr = 0;
                          Reactie re = new Reactie(eventNr,gevaarNr,rs.getInt("PersoonNr"), rs.getString("Reactie"),datum);
                          reactieLijstGevaar.add(re);
                  }
           }
           catch (SQLException e) 
		{
			e.printStackTrace();
		}
           return reactieLijstGevaar;

        }
   }

    
 
    
    
    
