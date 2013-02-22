/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domein;

/**
 *
 * @author arne
 */
public class Reactie 
{
    private int meldingNr,persoonNr;
    private String reactie;

    public Reactie(int meldingNr, int persoonNr, String reactie) {
        this.meldingNr = meldingNr;
        this.persoonNr = persoonNr;
        this.reactie = reactie;
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

    public String getReactie() {
        return reactie;
    }

    public void setReactie(String reactie) {
        this.reactie = reactie;
    }
    
    
    
}
