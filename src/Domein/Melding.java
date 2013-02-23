/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domein;


public class Melding 
{
    private int meldingNr,persoonNr,fotoNr;
    private String straatNaam,gemeente,omschrijving;

    
    
    
    public int getMeldingNr() {
        return meldingNr;
    }

    public void setMeldingNr(int meldingNr) {
        this.meldingNr = meldingNr;
    }

    public int getPersoonNr() {
        return persoonNr;
    }

    public void setPersoonNr(int persoonNr) {
        this.persoonNr = persoonNr;
    }

    public int getFotoNr() {
        return fotoNr;
    }

    public void setFotoNr(int fotoNr) {
        this.fotoNr = fotoNr;
    }

    public String getStraatNaam() {
        return straatNaam;
    }

    public void setStraatNaam(String straatNaam) {
        this.straatNaam = straatNaam;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }
    
}
