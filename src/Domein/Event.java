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
public class Event extends Melding
{
    private String Type;
    private List Categorie;
    

	



	public Event(String Type, List Categorie) 
        {
		super();
		this.Type = Type;
                this.Categorie = Categorie;
        }

    /**
     * @return the Type
     */
    public String getType() {
        return Type;
    }

    /**
     * @param Type the Type to set
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    /**
     * @return the Categorie
     */
    public List getCategorie() {
        return Categorie;
    }

    /**
     * @param Categorie the Categorie to set
     */
    public void setCategorie(List Categorie) {
        this.Categorie = Categorie;
    }
        
	
}
