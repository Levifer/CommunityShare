/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package communityshare;

import Domein.ModelPersoon;
import Domein.Persoon;
import Persistentie.Connectie;
import Persistentie.PersoonDAO;

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
        Connectie c = new Connectie();
        PersoonDAO pd = new PersoonDAO();
        
        Persoon p = new Persoon(0, 0, null, null);
        //pd.voegEenPersoonToe(p);
       // c.testConnection();
        ModelPersoon mp =  new ModelPersoon( );
        
        
         String twitter =null;
         String facebook = "facebook";
         //pd.logIn(facebook, twitter);
        mp.LogInFacebook(facebook);
         //mp.LogInTwitter(twitter);
       p= mp.getPl();
       
       System.out.println(p.getFacebookAccount());
       System.out.println(p.getPersoonNr());
       
       
       
    }
}
