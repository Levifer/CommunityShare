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
    private int MeldingNr,PersoonNr;
    private String Reactie;

    public Reactie(int MeldingNr, int PersoonNr, String Reactie) {
        this.MeldingNr = MeldingNr;
        this.PersoonNr = PersoonNr;
        this.Reactie = Reactie;
    }

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

    public String getReactie() {
        return Reactie;
    }

    public void setReactie(String Reactie) {
        this.Reactie = Reactie;
    }
    
    
    
}
