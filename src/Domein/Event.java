
package Domein;

import java.util.List;


public class Event extends Melding
{
    private String type;
    private String categorie;
    

	



	public Event(String Type, String Categorie) 
        {
		super();
		this.type = Type;
                this.categorie = Categorie;
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
