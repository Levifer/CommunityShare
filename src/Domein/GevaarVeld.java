/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domein;

import java.util.List;

/**
 *
 * @author arne
 */
public class GevaarVeld extends Melding {

    private String type;
    private String categorie;

    public GevaarVeld(String type, String categorie) 
    {
        this.type = type;
        this.categorie = categorie;
    }

    public String getType() 
    {
        return type;
    }

    public void setType(String type) 
    {
        this.type = type;
    }

    public String getCategorie() 
    {
        return categorie;
    }

    public void setCategorie(String categorie) 
    {
        this.categorie = categorie;
    }
}
