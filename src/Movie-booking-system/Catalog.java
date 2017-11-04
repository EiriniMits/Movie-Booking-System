package mainn;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Περιλαμβάνει ένα ArrayList που περιέχει όλα τα αντικείμενα τύπου Cinema,που έχουν δημιουργηθεί,δηλαδή όλες τις αίθουσες Cinema και ένα ArrayList με όλα τα αντικείμενα τύπου Theatre,που έχουν δημιουργηθεί,δηλαδή όλες τις αίθουσες Θεάτρου
 * @author Μητσοπούλου Ειρήνη
 * @author Παπαδοπούλου Κωνσταντίνα
 * @version 8.0.1 Jan 05, 2015
 */
public class Catalog implements Serializable{
    private final ArrayList<Hall> array;
    private final ArrayList<Cinema> arrayc;
    private final ArrayList<Theatre> arrayt;
    
    public Catalog(){
        array = new ArrayList<>();
        arrayc = new ArrayList<>();
        arrayt = new ArrayList<>();  
      
    }
    /**
     * Προσθέτει μία αίθουσα Κινηματογράφου
     * @param aCinHall 
     */    
    public void addCinHall(Cinema aCinHall){
        arrayc.add(aCinHall);
      
    }
    
    /**
     * Προσθέτει μία αίθουσα Θεάτρου
     * @param aTheHall 
     */
    public void addThHall(Theatre aTheHall){
        arrayt.add(aTheHall);
    }
 
    /**
     * Επιστρέφει την λίστα με όλες τις αίθουσες κινηματογράφου που έχουν καταχωρηθεί
     * @return arrayc
     */
    public ArrayList<Cinema> getCinemaHalls(){
        return arrayc;
    }
    
    /**
     * Επιστρέφει την λίστα με όλες τις αίθουσες Θεάτρου που έχουν καταχωρηθεί
     * @return arrayt
     */
    public ArrayList<Theatre> getThHalls(){
        return arrayt;
    }
    
    /**
     * Αφαιρεί μία αίθουσα κινηματογράφου
     * @param i 
     */
    public void removeCinHall(int i){
        arrayc.remove(i);
    }
    
    /**
     * Αφαιρεί μία αθουσα Θεάτρου
     * @param i 
     */
    public void removeThHall(int i){
        arrayt.remove(i);
    }
    
}