
package Persistentie;

import Domein.Event;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

public class EventMapper 
{
    
 


	//deze klasse is voor gegevens in de databank te steken, uit te halen, up te date en te verwijderen voor de table Inbox 
	
	public List<Event> geefLijstEvent(String gemeente) 
	{
		List<Event> Gegevenslijst = new ArrayList<Event>();
		Statement statement;
		Connectie connect = new Connectie();
		
		try 
		{
			statement = connect.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT MeldingNr, Omschrijving FROM Event WHERE Gemeente ='"+gemeente+"' Order by Datum decs ");
			
			while (rs.next()) 
			{
                                   String categorieEvent=null;
                                   int persoonNr=0;
                                   int fotoNr=0;
                                    int teller=0;
                                    String straatNaam = null;
                                    String gemeent = null;
                                     Date datum= null;
				 
				Event e = new Event(categorieEvent,rs.getInt("MeldingNr"),persoonNr,fotoNr,teller,straatNaam,gemeente,rs.getString("Omschrijving"),datum);
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
	public void verwijderenVanEenEvent(int meldingNr,int persoonNr) 
	{
                Connectie connect = new Connectie();
		
			try
                        {
				String sql="DELETE FROM Event WHERE ("
                                        + "MeldingNr,"
                                        + "PersoonNr) "
                                        + "VALUES(?,?)";			
				PreparedStatement pstmt = connect.getConnection().prepareStatement(sql);	
                                pstmt.setInt(1, meldingNr);
				pstmt.executeUpdate();
				pstmt.close();										
				connect.closeConnection();
                        }
			catch(SQLException e)
			{
				System.out.println("deze event bestaat niet of u bent niet eigenaar van dit event ");				
			}
			
		
	} 
	public void aanmakenVanEenEvent(Event e) 
	{
                Connectie connect = new Connectie();

                        try
                        {
                        // String categorieEvent, int meldingNr, int persoonNr, int fotoNr, int teller, String straatNaam, String gemeente, String omschrijving, Date datum		
			PreparedStatement pstmt = connect.getConnection().prepareStatement("INSERT INTO Event("
                                + "CategorieEvent,"
                                + "MeldingNr,"
                                + "PersoonNr,"
                                + "FotoNr,"
                                + "Teller,"
                                + "StraatNaam,"
                                + "gemeente,"
                                + "omschrijving,"
                                + "datum) "
                                + "VALUES(?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, e.getCategorie());
                        pstmt.setInt(2, e.getMeldingNr());
                        pstmt.setInt(3,e.getPersoonNr());
                        pstmt.setInt(4,e.getFotoNr());
                        pstmt.setInt(5,e.getTeller());
                        pstmt.setString(6,e.getStraatNaam());
                        pstmt.setString(7, e.getGemeente());
                        pstmt.setString(8, e.getOmschrijving());
                        pstmt.setDate(9, e.getDatum());
                        
					
						
			pstmt.executeUpdate();
			connect.closeConnection();
		}

		catch (SQLException sqlException) 
		{
			System.out.println("Database error");
		} 
	}    
    public Inbox zoekLijst(String title,String auteur)
	{
		Inbox ib = new Inbox();
		Statement statement;
		connection connecti = new connection();
		
		try
	    {
		statement = connecti.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM Inbox WHERE Title ='"+title+"'AND Gebruiker='"+auteur+"'");
	
		while(rs.next())
		{
			 String titles=rs.getString("Title");
			 Blob afbeelding=rs.getBlob("Afbeelding");
			 String commentaar=rs.getString("Commentaar");
			 String tijd=rs.getString("Tijd");
			 String gebruiker=rs.getString("Gebruiker");
			 String type=rs.getString("Type");
			 
				InputStream imageBlobStream=afbeelding.getBinaryStream();
				BufferedImage Afbeelding=ImageIO.read(imageBlobStream);

			 
			 ib = new Inbox( titles,Afbeelding,commentaar,tijd,gebruiker,type);
			
		}
		connecti.closeConnection();

	    }
		catch(SQLException e)
		{
			System.out.println( "Post bestaat niet!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ib;
	}
}
