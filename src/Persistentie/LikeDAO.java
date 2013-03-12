/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistentie;

import Domein.Like;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author arne
 */
public class LikeDAO {
    
    //zoeken niet nodig
    
    // aanmaken/toevoegen van like, persoonnr,meldingnr,boolean
    public void aanmakenVanEenLike(Like l){
        Connectie connecti = new Connectie();
        Statement statement;
        try{
            statement = connecti.getConnection().createStatement();
            String sql=("INSERT INTO like( "
                    + "EventNr,"
                    + "GevaarNr,"
                    + "PersoonNr,"
                    + "Liken )"
                    + "VALUES(?,?,?,?)");
            
            PreparedStatement pstmt = connecti.getConnection().prepareStatement(sql);
            pstmt.setInt(1,l.getEventNr());
            pstmt.setInt(2, l.getGevaarNr());
            pstmt.setInt(3,l.getPersoonNr());
            pstmt.setBoolean(4,l.isLiken());
            
            pstmt.executeUpdate();
           
            connecti.closeConnection();
        }   
        catch (SQLException sqlException) {
                        System.out.print("Database Error");
                        sqlException.getMessage();

			System.exit(1);
			}
          
    }
    
    // verwijderen van like
    public void verwijderenVanEenLike(Like l){
         Connectie connecti = new Connectie();
         Statement statement;
        try{
            statement= connecti.getConnection().createStatement();
            String sql= ("DELETE FROM like WHERE("
                    + "EventNr"
                    + "GevaarNr"
                    + "PersoonNr,"
                    + "Liken )"
                    + "VALUES(?,?,?,?)");
            
            PreparedStatement pstmt = connecti.getConnection().prepareStatement(sql);
             pstmt.setInt(1, l.getEventNr());
             pstmt.setInt(2, l.getGevaarNr());
             pstmt.setInt(3, l.getPersoonNr());
             pstmt.setBoolean(4, l.isLiken());
             pstmt.executeUpdate();
             pstmt.close();
             connecti.closeConnection();
            
        }   
       catch (SQLException sqlException) {
                        System.out.print("Database Error");
                        sqlException.getMessage();

			System.exit(1);
			}

    }
    
}
