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
    private int eventNr,gevaarNr,persoonNr;
    private boolean liken;

    public Like(int eventNr, int gevaarNr, int persoonNr, boolean liken) {
        this.eventNr = eventNr;
        this.gevaarNr = gevaarNr;
        this.persoonNr = persoonNr;
        this.liken = liken;
    }

    public int getEventNr() {
        return eventNr;
    }

    public void setEventNr(int eventNr) {
        this.eventNr = eventNr;
    }

    public int getGevaarNr() {
        return gevaarNr;
    }

    public void setGevaarNr(int gevaarNr) {
        this.gevaarNr = gevaarNr;
    }

    public int getPersoonNr() {
        return persoonNr;
    }

    public void setPersoonNr(int persoonNr) {
        this.persoonNr = persoonNr;
    }

    public boolean isLiken() {
        return liken;
    }

    public void setLiken(boolean liken) {
        this.liken = liken;
    }


    
}
