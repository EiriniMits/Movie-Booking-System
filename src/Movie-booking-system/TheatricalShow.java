
package mainn;

/**
 * Κληρονoμει ολα τα πεδια της κλασης Show που ειναι και τα χαρακτηριστικα μιας θεατρικης παραστασης
 * @author Μητσοπούλου Ειρήνη
 * @author Παπαδοπούλου Κωνσταντίνα
 * @version 8.0.1 Nov 22, 2014
 */
public class TheatricalShow extends Show{
    /**
     * @param showName
     * @param showDescription
     * @param director
     * @param actorList
     * @param date
     * @param price
     * */
    public TheatricalShow(String showName,String showDescription,String director,String actorList,String[] date,int price){
        super(showName,showDescription,director,actorList,date,price);
    }
    
    
}
