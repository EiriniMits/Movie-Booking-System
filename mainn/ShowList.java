package mainn;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Περιλαμβάνει ένα ArrayList που περιέχει όλα τα αντικείμενα τύπου Movies,που έχουν δημιουργηθεί,δηλαδή όλες τις ταινίες και ένα ArrayList με όλα τα αντικείμενα τύπου TheatricalShow,που έχουν δημιουργηθεί,δηλαδή όλες τις θεατρικές παραστάσεις
 * @author Μητσοπούλου Ειρήνη
 * @author Παπαδοπούλου Κωνσταντίνα
 * @version 8.0.1 Jan 05, 2015
 */
public class ShowList implements Serializable{
    
    private final ArrayList<Movies> arraym;
    private final ArrayList<TheatricalShow> arrayt;
    
    public ShowList(){
        arraym = new ArrayList<>();
        arrayt = new ArrayList<>();
    }
    
    /**
     * Προσθέτει μία ταινία
     * @param show 
     */
    public void addMShow(Movies show){
        arraym.add(show);
    }
    
    /**
     * Προσθέτει μία θεατρική παράσταση
     * @param Show 
     */
    public void addTShow(TheatricalShow Show){
        arrayt.add(Show);
    }
    
    /**
     * Επισρέφει την λίστα με όλες τις ταινίες που έχουν καταχωρηθεί
     * @return arraym
     */
    public ArrayList<Movies> getMShows(){
        return arraym;
    }
    
    /**
     * Επισρέφει την λίστα με όλες τις θεατρικές παραστάσεις που έχουν καταχωρηθεί
     * @return arrayt
     */
    public ArrayList<TheatricalShow> getTShows(){
        return arrayt;
    }
    
    /**
     * Αφαιρεί μία ταινία
     * @param i 
     */
    public void removeMShow(int i){
        arraym.remove(i);

    }
    
    /**
     * Αφαιρεί μία θεατρική παράσταση
     * @param i 
     */
    public void removeTShow(int i){
        arrayt.remove(i);
    }
}
