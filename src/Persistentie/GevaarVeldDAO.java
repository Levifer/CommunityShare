/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistentie;


import Domein.GevaarVeld;
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
public class GevaarVeldDAO
{
      private GevaarVeld gv;
 


	//deze klasse is voor gegevens in de databank te steken, uit te halen, up te date en te verwijderen voor de table Inbox 
	
	public List<GevaarVeld> geefLijstGevaarVeld(String gemeente) 
	{
		List<GevaarVeld> Gegevenslijst = new ArrayList<GevaarVeld>();
		Statement statement;
		Connectie connect = new Connectie();
		
		try 
		{
			statement = connect.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT GevaarNr, Omschrijving FROM gevaarveld WHERE Gemeente ='"+gemeente+"' Order by Datum decs ");
			
			while (rs.next()) 
			{
                                   String categorieGevaar=null;
                                   int persoonNr=0;
                                   int fotoNr=0;
                                    int teller=0;
                                    String straatNaam = null;
                                    String gemeent = null;
                                     Date datum= null;
				 
				GevaarVeld e = new GevaarVeld(categorieGevaar,
                                        rs.getInt("GevaarNr"),
                                        persoonNr,
                                        fotoNr,
                                        teller,
                                        straatNaam,
                                        gemeente,
                                        rs.getString("Omschrijving"),
                                        datum);
                                
				Gegevenslijst.add(e);	
                           }
			connect.closeConnection();
			statement.close();
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return Gegevenslijst;
	}
	public void verwijderenVanEenGevaarVeld(int gevaarNr,int persoonNr) 
	{
                Connectie connect = new Connectie();
		
			try
                        {
				String sql="DELETE FROM gevaarveld WHERE ("
                                        + "GevaarNr,"
                                        + "PersoonNr) "
                                        + "VALUES(?,?)";			
				PreparedStatement pstmt = connect.getConnection().prepareStatement(sql);	
                                pstmt.setInt(1, gevaarNr);
				pstmt.executeUpdate();
				pstmt.close();										
				connect.closeConnection();
                        }
			catch(SQLException e)
			{
				System.out.println("deze event bestaat niet of u bent niet eigenaar van dit Gevaarsveld ");				
			}
			
		
	} 
	public void aanmakenVanEenGevaarVeld(GevaarVeld gv) 
	{
                Connectie connect = new Connectie();

                        try
                        {
                        // String categorieEvent, int meldingNr, int persoonNr, int fotoNr, int teller, String straatNaam, String gemeente, String omschrijving, Date datum		
			PreparedStatement pstmt = connect.getConnection().prepareStatement("INSERT INTO gevaarveld("
                                + "CategorieGevaar,"
                                + "GevaarNr,"
                                + "PersoonNr,"
                                + "FotoNr,"
                                + "Teller,"
                                + "StraatNaam,"
                                + "gemeente,"
                                + "omschrijving,"
                                + "datum) "
                                + "VALUES(?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, gv.getCategorie());
                        pstmt.setInt(2, gv.getGevaarNr());
                        pstmt.setInt(3,gv.getPersoonNr());
                        pstmt.setInt(4,gv.getFotoNr());
                        pstmt.setInt(5,gv.getTeller());
                        pstmt.setString(6,gv.getStraatNaam());
                        pstmt.setString(7, gv.getGemeente());
                        pstmt.setString(8, gv.getOmschrijving());
                        pstmt.setDate(9, gv.getDatum());
                        
					
						
			pstmt.executeUpdate();
			connect.closeConnection();
		}

		catch (SQLException sqlException) 
		{
			System.out.println("Database error");
		} 
	}    
    public GevaarVeld zoekLijstGevaarVeld(int gevaarNr)
	{
		
		Statement statement;
		Connectie connect = new Connectie();
		
		try
	    {
		statement = connect.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM gevaarveld WHERE GevaarNr ='"+gevaarNr+"'");
	
		while(rs.next())
		{
			
			 
				

			 gv = new GevaarVeld(rs.getString("CategorieGevaar"),
                         rs.getInt("GevaarNr"),
                         rs.getInt("PersoonNr"),
                         rs.getInt("FotoNr"),
                         rs.getInt("Teller"),
                         rs.getString("StraatNaam"),
                         rs.getString("Gemeente"),
                         rs.getString("Omschrijving"),
                         rs.getDate("Datum"));
			 
			
		}
		connect.closeConnection();

	    }
		catch(SQLException e)
		{
			System.out.println( "Gevaar bestaat niet!");
			
		} 
		return gv;
	}
}
    

