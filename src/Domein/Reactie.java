/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domein;

import java.sql.Date;

/**
 *
 * @author arne
 */
public class Reactie 
{
    private int eventNr,gevaarNr,persoonNr;
    private String reactie;
    private Date datum;

    public Reactie(int eventNr, int gevaarNr, int persoonNr, String reactie, Date datum) {
        this.eventNr = eventNr;
        this.gevaarNr = gevaarNr;
        this.persoonNr = persoonNr;
        this.reactie = reactie;
        this.datum = datum;
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

    public String getReactie() {
        return reactie;
    }

    public void setReactie(String reactie) {
        this.reactie = reactie;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }


    
    
    
}
