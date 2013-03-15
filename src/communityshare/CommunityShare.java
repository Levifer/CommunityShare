/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package communityshare;

import Domein.Event;
import Domein.Foto;
import Domein.ModelPersoon;
import Domein.Persoon;
import Persistentie.Connectie;
import Persistentie.EventDAO;
import Persistentie.FotoDAO;
import Persistentie.PersoonDAO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Ben
 */
public class CommunityShare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
//testen van de database connectie
        
        // Connectie c = new Connectie();
        // c.testConnection();
        
       
// een persoon met een facebook of twitterAccount toevoegen
        
       /* Persoon p = new Persoon(0, 0, "facebook", null);
        Persoon P2 = new Persoon(0,0,null,"twitter");
      
        PersoonDAO pd = new PersoonDAO();
        pd.voegEenPersoonToe(p);
        pd.voegEenPersoonToe(P2);*/
        
        
//een persoon doen login met een facebook of een twitter account
        ModelPersoon mp =  new ModelPersoon( );
        Persoon p = new Persoon(0,0,null,null);
         String twitter2="twitter";
         String facebook = "facebook";
         
           mp.LogInFacebook(facebook);
         //mp.LogInTwitter(twitter2);
            p= mp.getPl();
       
       System.out.println(p.getFacebookAccount());
       System.out.println(p.getPersoonNr());

//het toevoegen van een foto
       FotoDAO Fdao= new FotoDAO();
       BufferedImage afbeelding=null;
        try {       
            afbeelding = ImageIO.read(new File("images.jpg"));
        } catch (IOException ex) 
        {
            System.out.println("fout bij foto inlezen");
            
        }
       Foto f = new Foto(0,afbeelding);
       int primkey;
       primkey=Fdao.nieuweFoto(f);
       System.out.println(primkey);
       
       
       
       
       
// een melding toevoegen van een event of een gevaar 
       
       EventDAO eDAO = new EventDAO();
     
       java.util.Date today = new java.util.Date();
       java.sql.Date datum = new java.sql.Date(today.getTime());
       
       Event e = new Event("buurfeest",primkey,p.getPersoonNr(),1,0,"stationsstraat","Aalst","toffe bbq in de straat",datum);
       
       eDAO.aanmakenVanEenEvent(e);
       
       
       
       
    }
}
