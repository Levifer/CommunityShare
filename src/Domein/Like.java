/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domein;

/**
 *
 * @author arne
 */
public class Like 
{
    private int MeldingNr,PersoonNr;
    private boolean Liken;

    public Like(int MeldingNr, int PersoonNr, boolean Liken) 
    {
        this.MeldingNr = MeldingNr;
        this.PersoonNr = PersoonNr;
        this.Liken = Liken;
    }
    
    

    public int getMeldingNr() 
    {
        return MeldingNr;
    }

    public void setMeldingNr(int MeldingNr) 
    {
        this.MeldingNr = MeldingNr;
    }

    public int getPersoonNr()
    {
        return PersoonNr;
    }

    public void setPersoonNr(int PersoonNr) 
    {
        this.PersoonNr = PersoonNr;
    }

    public boolean isLiken() 
    {
        return Liken;
    }

    public void setLiken(boolean Liken)
    {
        this.Liken = Liken;
    }
    
}
