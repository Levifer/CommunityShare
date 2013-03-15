
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

public class EventDAO 
{
    private Event e;
 


	//deze klasse is voor gegevens in de databank te steken, uit te halen, up te date en te verwijderen voor de table Inbox 
	
	public List<Event> geefLijstEvent(String gemeente) 
	{
		List<Event> Gegevenslijst = new ArrayList<Event>();
		Statement statement;
		Connectie connect = new Connectie();
		
		try 
		{
			statement = connect.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT EventNr, Omschrijving FROM event WHERE Gemeente ='"+gemeente+"' Order by Datum decs ");
			
			while (rs.next()) 
			{
                                   String categorieEvent=null;
                                   int persoonNr=0;
                                   int fotoNr=0;
                                    int teller=0;
                                    String straatNaam = null;
                                    String gemeent = null;
                                     Date datum= null;
				 
				Event e = new Event(categorieEvent,
                                        rs.getInt("EventNr"),
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
	public void verwijderenVanEenEvent(int eventNr,int persoonNr) 
	{
                Connectie connect = new Connectie();
		
			try
                        {
				String sql="DELETE FROM event WHERE ("
                                        + "EventNr,"
                                        + "PersoonNr) "
                                        + "VALUES(?,?)";			
				PreparedStatement pstmt = connect.getConnection().prepareStatement(sql);	
                                pstmt.setInt(1, eventNr);
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
			PreparedStatement pstmt = connect.getConnection().prepareStatement("INSERT INTO event("
                                + "CategorieEvent,"
                                + "EventNr,"
                                + "PersoonNr,"
                                + "FotoNr,"
                                + "Teller,"
                                + "StraatNaam,"
                                + "gemeente,"
                                + "omschrijving,"
                                + "datum) "
                                + "VALUES(?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, e.getCategorie());
                        pstmt.setInt(2, e.getEventNr());
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
    public Event zoekLijst(int eventNr)
	{
		
		Statement statement;
		Connectie connect = new Connectie();
		
		try
	    {
		statement = connect.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM event WHERE EventNr ='"+eventNr+"'");
	
		while(rs.next())
		{
			
			 
				

			 e = new Event(rs.getString("CategorieEvent"),
                         rs.getInt("EventNr"),
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
			System.out.println( "Event bestaat niet!");
			
		} 
		return e;
	}
}
