
package Domein;

import java.util.Date;




public class Event extends Melding
{
    
    private String categorieEvent;

    public Event(String categorieEvent, int meldingNr, int persoonNr, int fotoNr, int teller, String straatNaam, String gemeente, String omschrijving, Date datum) {
        super(meldingNr, persoonNr, fotoNr, teller, straatNaam, gemeente, omschrijving, datum);
        this.categorieEvent = categorieEvent;
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
