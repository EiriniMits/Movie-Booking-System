
package mainn;

/**
 * Κληρονoμει ολα τα πεδια της κλασης Show και περιεχει και τα μοναδικα χαρακτηριστικα μιας ταινιας 
 * που την κανουν να διαφερει απο μια θεατρικη παρασταση
 * @author Μητσοπούλου Ειρήνη
 * @author Παπαδοπούλου Κωνσταντίνα
 * @version 8.0.1 Nov 22, 2014
 */
public class Movies extends Show{
    private int duration;
    /**
     * @param showName
     * @param showDescription
     * @param director
     * @param actorList
     * @param price
     * @param date
     * @param duration1
     * */
    public Movies(int duration1,String showName,String showDescription,String director,String actorList,String[] date,int price){
        super(showName,showDescription,director,actorList,date,price);
        duration = duration1;
    }
    
    /**
    * Επιστρεφει τη διαρκεια της ταινιας
    * @return duration
    **/
    public int getDuration(){
        return duration;
    }
    /**
    * Aλλαζει τη διαρκεια της ταινιας
    * @param duration1
    **/
    public void changeDuration(int duration1){
        duration = duration1;
    }
}
