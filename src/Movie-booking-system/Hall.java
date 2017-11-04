
package mainn;
import java.io.Serializable;

/**
 * Περιεχει τα κοινα χαρακτηριστικα μιας αιθουσας cinema και μιας θεατρικης παραστασης
 * @author Μητσοπούλου Ειρήνη
 * @author Παπαδοπούλου Κωνσταντίνα
 * @version 8.0.1 Nov 22, 2014
 */
public class Hall implements Serializable{
    private String hallName;
    private int capacity;
    private String seatType;
    private final int rownumber;
    private int[] seats = new int[20];
    int[] checkseats = new int[200];
    /**
     * @param  hallName1
     * @param  capacity1
     * @param  seatType1
     * @param  rownumber1
     * @param  seats1
     * @param  checkseats1
     **/
    public Hall( String hallName1,int capacity1,String seatType1,int rownumber1,int[] seats1,int[] checkseats1){
        hallName = hallName1;
        capacity = capacity1;
        seatType = seatType1;
        rownumber = rownumber1;
        seats = seats1;
        checkseats = checkseats1;
    }
    
    
    /**
    * Επιστρεφει το ονομα της αιθουσας
    * @return  hallName
    **/
    public String gethallName(){
        return hallName;
    }
    /**
    * Aλλαζει το ονομα της αιθουσας
    * @param  hallName1
    **/
    public void changehallName(String hallName1){
        hallName = hallName1;
    }
    
    /**
    * Επιστρεφει τη χωριτηκοτητα της αιθουσας
    * @return capacity
    **/
    public int getcapacity(){
        return capacity;
    }
    /**
    * Aλλαζει τη χωριτηκοτητα της αιθουσας
    * @param capacity1
    **/
    public void changecapacity(int capacity1){
        capacity = capacity1;
    }
    
    /**
    * Επιστρεφει τον τυπο των θεσεων (απλες ή πολυτελειας)
    * @return seatType
    **/
    public String getseatType(){
       return seatType;
    }
    /**
    * Aλλαζει τον τυπο των θεσεων (απλες ή πολυτελειας)
    * @param seatType1
    **/
    public void changeseatType(String seatType1){
       seatType = seatType1;
    }
    
    /**
    * Επιστρεφει τον αριθμο των σειρων της αιθουσας
    * @return rownumber
    **/
    public int getrownumber(){
        return rownumber;
    }
    
    /**
    * Επιστρεφει τον τροπο που ειναι κατανεμημενες οι θεσεις σε καθε αιθουσα με μορφη πινακα 
    * οπου ο δεικτης διχνει τη σειρα και η τιμη των αριθμο των θεσεων
    * @return seats
    **/
    public int[] getSeats(){       
        return seats;
    } 
    
    /**
    * Επιστρεφει τον πίνακα οπου φαίνεται ποιες θέσεις ειναι κλεισμενες
    * @return checkseats
    **/
    public int[] getcheckseats(){
        return checkseats;
    }
    /**
    * Aλλαζει τον πίνακα οπου φαίνεται ποιες θέσεις ειναι κλεισμενες
    * @param checkseats1
    **/
    public void changecheckseats(int[] checkseats1){
         checkseats = checkseats1;
    }
}
