/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domein;

import java.util.Date;


public class Melding 
{
    private int meldingNr,persoonNr,fotoNr,teller;//teller zodat de melding kan bijhouden hoeveel er het gelike of gedisliked hebben
    private String straatNaam,gemeente,omschrijving;
    private Date datum;

    public Melding(int meldingNr, int persoonNr, int fotoNr, int teller, String straatNaam, String gemeente, String omschrijving, Date datum) {
        this.meldingNr = meldingNr;
        this.persoonNr = persoonNr;
        this.fotoNr = fotoNr;
        this.teller = teller;
        this.straatNaam = straatNaam;
        this.gemeente = gemeente;
        this.omschrijving = omschrijving;
        this.datum = datum;
    }



    
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
