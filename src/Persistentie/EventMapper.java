
package Persistentie;

import Domein.Event;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventMapper 
{
    
 

	private final static String LEES_EVENT_SQL = "SELECT * FROM Event Order by MeldingNr asc";
	////deze klasse is voor gegevens in de databank te steken, uit te halen, up te date en te verwijderen voor de table Inbox 
	
	public List<Event> geefLijst(String gemeente) 
	{
		List<Event> Gegevenslijst = new ArrayList<Event>();
		Statement statement;
		Connectie connecti = new Connectie();
		
		try 
		{
			statement = connecti.getConnection().createStatement();
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
			connecti.closeConnection();
			statement.close();
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Gegevenslijst;
	}
	public void verwijderEenEvent(int meldingNr) 
	{
		Connectie connecti = new Connectie();
		
			try
		    {
				String sql="DELETE FROM Inbox WHERE Title ='"+title+"' AND Gebruiker='"+gebruiker+"'";			
				PreparedStatement ps = connecti.getConnection().prepareStatement(sql);			
				ps.executeUpdate();
				ps.close();										
				connecti.closeConnection();
		    }
			catch(SQLException e)
			{
				JOptionPane.showMessageDialog(null, "Post bestaat niet!");				
			}
			
		
	} 
	public void nieuweItem(Inbox ib) 
	{
		connection connecti = new connection();

		try
		{			
			
			Blob afbeelding=connecti.getConnection().createBlob();
			OutputStream afbeeldingStream=afbeelding.setBinaryStream(1);
			ImageIO.write(ib.getAfbeelding(),"png",afbeeldingStream);
			
			Statement s = connecti.getConnection().createStatement();//connectie maken
			ResultSet rs = s.executeQuery("SELECT Title FROM Inbox ORDER BY Title desc");
			rs.next();			
			PreparedStatement pstmt = connecti.getConnection().prepareStatement("INSERT INTO Inbox(Title,Afbeelding,Commentaar,Tijd,Gebruiker,Type) VALUES(?,?,?,?,?,?)");
			pstmt.setString(1, ib.getTitle());
			pstmt.setBlob(2, afbeelding);
			pstmt.setString(3, ib.getCommentaar());
			pstmt.setString(4, ib.getTijd());
			pstmt.setString(5, ib.getGebruiker());
			pstmt.setString(6, ib.getType());			
						
			pstmt.executeUpdate();
			connecti.closeConnection();
		}

		catch (SQLException sqlException) 
		{
			JOptionPane.showMessageDialog(null, sqlException.getMessage(),"Database Error", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
