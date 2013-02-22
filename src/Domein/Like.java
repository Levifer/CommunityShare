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
    private int meldingNr,persoonNr;
    private boolean liken;

    public Like(int meldingNr, int persoonNr, boolean liken) 
    {
        this.meldingNr = meldingNr;
        this.persoonNr = persoonNr;
        this.liken = liken;
    }
    
    

    public int getMeldingNr() 
    {
        return meldingNr;
    }

    public void setMeldingNr(int meldingNr) 
    {
        this.meldingNr = meldingNr;
    }

    public int getPersoonNr()
    {
        return persoonNr;
    }

    public void setPersoonNr(int persoonNr) 
    {
        this.persoonNr = persoonNr;
    }

    public boolean isLiken() 
    {
        return liken;
    }

    public void setLiken(boolean liken)
    {
        this.liken = liken;
    }
    
}
