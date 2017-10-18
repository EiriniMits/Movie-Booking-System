
package mainn;

/**
 *Κληρονoμει ολα τα πεδια της κλασης Hall και περιεχει και τα μοναδικα χαρακτηριστικα μιας αιθουσας θεατρικης παραστασης 
 * που την κανουν να διαφερει απο μια αιθουσα cinema
 * @author Μητσοπούλου Ειρήνη
 * @author Παπαδοπούλου Κωνσταντίνα
 * @version 8.0.1 Nov 22, 2014
 */
public class Theatre extends Hall{
    private int balcony;
    private int dressingRoom;
    /**
     * @param  hallName
     * @param  rownumber
     * @param  checkseats
     * @param  capacity
     * @param  seatType
     * @param  seats
     * @param  balcony1
     * @param  dressingRoom1
     * */
    public Theatre(String hallName,int capacity,String seatType,int rownumber,int[] seats,int[] checkseats,int balcony1,int dressingRoom1){
        super(hallName,capacity,seatType,rownumber,seats,checkseats);
        balcony = balcony1;
        dressingRoom = dressingRoom1;
    }
    
    /**
    * Επιστρεφει τον αριθμο των εξώστεων
    * @return balcony
    **/
    public int getbalcony(){
       return balcony;
    }
    /**
    * Aλλαζει τον αριθμο των εξώστεων
    * @param balcony1
    **/
    public void changebalcony(int balcony1){
       balcony = balcony1;
    }
    
    /**
    * Επιστρεφει τον αριθμο των καμαρινιων
    * @return dressingRoom
    **/
    public int getdressingRoom(){
        return dressingRoom;
    }
    /**
    * Aλλαζει τον αριθμο των καμαρινιων
    * @param dressingRoom1
    **/
    public void changedressingRoom(int dressingRoom1){
        dressingRoom = dressingRoom1;
    }
}
