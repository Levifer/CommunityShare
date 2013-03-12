/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domein;


import java.sql.Date;
import java.util.List;

/**
 *
 * @author arne
 */
public class GevaarVeld extends Melding {

   
    private String categorieGevaar;
    private int gevaarNr;

    
    public GevaarVeld(String categorieGevaar, int gevaarNr, int persoonNr, int fotoNr, int teller, String straatNaam, String gemeente, String omschrijving, Date datum) 
    {
        super(persoonNr, fotoNr, teller, straatNaam, gemeente, omschrijving, datum);
        this.categorieGevaar = categorieGevaar;
    }

    public int getGevaarNr() {
        return gevaarNr;
    }

    public void setGevaarNr(int gevaarNr) {
        this.gevaarNr = gevaarNr;
    }




    public String getCategorie() 
    {
        return categorieGevaar;
    }

    public void setCategorie(String categorie) 
    {
        this.categorieGevaar = categorie;
    }
}
