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

    private String Type;
    private List Categorie;

    public GevaarVeld(String Type, List Categorie) 
    {
        this.Type = Type;
        this.Categorie = Categorie;
    }

    public String getType() 
    {
        return Type;
    }

    public void setType(String Type) 
    {
        this.Type = Type;
    }

    public List getCategorie() 
    {
        return Categorie;
    }

    public void setCategorie(List Categorie) 
    {
        this.Categorie = Categorie;
    }
}
