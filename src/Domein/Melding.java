/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domein;

/**
 *
 * @author arne
 */
public class Melding 
{
    private int MeldingNr,PersoonNr,FotoNr;
    private String StraatNaam,Gemeente,Omschrijving;

    
    
    
    public int getMeldingNr() {
        return MeldingNr;
    }

    public void setMeldingNr(int MeldingNr) {
        this.MeldingNr = MeldingNr;
    }

    public int getPersoonNr() {
        return PersoonNr;
    }

    public void setPersoonNr(int PersoonNr) {
        this.PersoonNr = PersoonNr;
    }

    public int getFotoNr() {
        return FotoNr;
    }

    public void setFotoNr(int FotoNr) {
        this.FotoNr = FotoNr;
    }

    public String getStraatNaam() {
        return StraatNaam;
    }

    public void setStraatNaam(String StraatNaam) {
        this.StraatNaam = StraatNaam;
    }

    public String getGemeente() {
        return Gemeente;
    }

    public void setGemeente(String Gemeente) {
        this.Gemeente = Gemeente;
    }

    public String getOmschrijving() {
        return Omschrijving;
    }

    public void setOmschrijving(String Omschrijving) {
        this.Omschrijving = Omschrijving;
    }
    
}
