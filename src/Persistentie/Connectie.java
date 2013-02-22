/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistentie;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
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
                 conn =  DriverManager.getConnection("jdbc:sqlserver://ARNE-PC;database=Lumen2;user=arne;password=arne");
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
                    JOptionPane.showMessageDialog(null, "Afsluiten van "
                    + "databank-connectie mislukt.");
                    e.printStackTrace();
                }
            }
        }
}
	

 
			
			
			

    
    

