
package Domein;

import java.sql.Date;






public class Event extends Melding
{
    
    private String categorieEvent;
    private int eventNr;

    public Event(String categorieEvent, int eventNr, int persoonNr, int fotoNr, int teller, String straatNaam, String gemeente, String omschrijving, Date datum)
    {
        super( persoonNr, fotoNr, teller, straatNaam, gemeente, omschrijving, datum);
        this.categorieEvent = categorieEvent;
    }

    public int getEventNr() {
        return eventNr;
    }

    public void setEventNr(int eventNr) {
        this.eventNr = eventNr;
    }



 

    
    public String getCategorie() 
    {
        return categorieEvent;
    }

   
    public void setCategorie(String categorie) 
    {
        this.categorieEvent = categorie;
    }
        
	
}
