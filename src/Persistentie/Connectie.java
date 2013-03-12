/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistentie;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author arne
 */ 
public class Connectie 
{
    	private Connection conn = null;
	
       public Connection getConnection()
	{
            Connectie t = null;
            try
            {
	
                 //conn = DriverManager.getConnection("jdbc:sqlserver://LumenData.mssql.somee.com;database=LumenData;user=LumenDatabase;password=Cs24Wt!!");
                 //conn = DriverManager.getConnection("jdbc:sqlserver://Lumendatabase.mssql.somee.com;database=Lumendatabase;user=lumen;password=Cs24Wt!!");
                 conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/databaseproject?user=root&password=mj3qbka4");
            }
            catch(SQLException e)
            {
                 System.out.println("!! ## FOUT BIJ CONNECTEREN MET DATABANK ## !!");
                 e.printStackTrace();
            }
          return conn;
	}

	public void closeConnection()
	{
            if(conn != null)
            {
                 try
                {
                 conn.close();
                }
                catch (SQLException e)
                {
                    System.out.print("Afsluiten van " + "databank-connectie mislukt.");   
                    e.printStackTrace();
                }
            }
        }
        public boolean testConnection(){
                boolean connection = true;
                showMessage("Testing Connection ********");
             try{
                     getConnection();
                     closeConnection();
                }
             catch(Exception e){
                    connection = false;
                    showMessage("Connection FAILED!");
                }
             finally{
                    showMessage("************ Testing Ended.");
                    }
                    return connection;
                 }
        
         private void showMessage(String message)
         {
                 System.out.println("Database: " + message);
         }
}
	

 
			
			
			

    
    

