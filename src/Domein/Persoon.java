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
    private int PersoonNr ,Score ;
    private String Email , FacebookAccount , TwitterAccount;

    public Persoon(int PersoonNr, int Score, String Email, String FacebookAccount, String TwitterAccount) {
        this.PersoonNr = PersoonNr;
        this.Score = Score;
        this.Email = Email;
        this.FacebookAccount = FacebookAccount;
        this.TwitterAccount = TwitterAccount;
    }





    
    public int getPersoonNr() {
        return PersoonNr;
    }

    public void setPersoonNr(int PersoonNr) {
        this.PersoonNr = PersoonNr;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFacebookAccount() {
        return FacebookAccount;
    }

    public void setFacebookAccount(String FacebookAccount) {
        this.FacebookAccount = FacebookAccount;
    }

    public String getTwitterAccount() {
        return TwitterAccount;
    }

    public void setTwitterAccount(String TwitterAccount) {
        this.TwitterAccount = TwitterAccount;
    }
    
    
}
