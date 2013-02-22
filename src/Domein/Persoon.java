/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domein;

/**
 *
 * @author arne
 */
public class Persoon 
{
    private int persoonNr ,score ;
    private String  facebookAccount , twitterAccount;

    public Persoon(int persoonNr, int score,  String facebookAccount, String twitterAccount) {
        this.persoonNr = persoonNr;
        this.score = score;
        this.facebookAccount = facebookAccount;
        this.twitterAccount = twitterAccount;
    }





    
    public int getPersoonNr() {
        return persoonNr;
    }

    public void setPersoonNr(int persoonNr) {
        this.persoonNr = persoonNr;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public String getFacebookAccount() {
        return facebookAccount;
    }

    public void setFacebookAccount(String facebookAccount) {
        this.facebookAccount = facebookAccount;
    }

    public String getTwitterAccount() {
        return twitterAccount;
    }

    public void setTwitterAccount(String twitterAccount) {
        this.twitterAccount = twitterAccount;
    }
    
    
}
