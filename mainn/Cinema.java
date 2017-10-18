
package mainn;

/**
 * Κληρονoμει ολα τα πεδια της κλασης Hall και περιεχει και τα μοναδικα χαρακτηριστικα μιας αιθουσας cinema 
 * που την κανουν να διαφερει απο μια αιθουσα θεατρικης παραστασης
 * @author Μητσοπούλου Ειρήνη
 * @author Παπαδοπούλου Κωνσταντίνα
 * @version 8.0.1 Nov 22, 2014
 */
public class Cinema extends Hall{
    private int screenSize;
    private String screenType;
    private String soundSystem;
    /**
     * @param  hallName
     * @param  capacity
     * @param  seatType 
     * @param rownumber 
     * @param  seats
     * @param checkseats
     * @param  screenSize1
     * @param  screenType1
     * @param  soundSystem1
     **/
    public Cinema(String hallName,int capacity,String seatType,int rownumber,int[] seats,int[] checkseats,int screenSize1,String screenType1,String soundSystem1){
        super(hallName,capacity,seatType,rownumber,seats,checkseats);
        screenSize = screenSize1;
        screenType = screenType1;
        soundSystem = soundSystem1;
    }
    
    /**
    * Επιστρεφει το μεγεθος της οθονης
    * @return screenSize
    **/
    public int getscreenSize(){
       return screenSize;
    }
    /**
    * Aλλαζει το μεγεθος της οθονης
    * @param screenSize1
    **/
    public void changescreenSize(int screenSize1){
        screenSize = screenSize1;
    }
    
    /**
    * Επιστρεφει τον τυπο της οθονης(3D, κανονικη)
    * @return screenType
    **/
    public String getscreenType(){
        return screenType;
    }
    /**
    * Aλλαζει τον τυπο της οθονης(3D, κανονικη)
    * @param screenType1
    **/
    public void changescreenType(String screenType1){
        screenType = screenType1;
    }
    
    /**
    * Επιστρεφει το συστημα ηχου της αιθουσας(Dolby Digital, Dolby Digital Surround, Dolby Digital Live, Dolby Digital Plus, Dolby TrueHD)
    * @return soundSystem
    **/
    public String getsoundSystem(){
       return soundSystem;
    }
    /**
    * Aλλαζει το συστημα ηχου της αιθουσας(Dolby Digital, Dolby Digital Surround, Dolby Digital Live, Dolby Digital Plus, Dolby TrueHD)
    * @param soundSystem1
    **/
    public void changesoundSystem(String soundSystem1){
       soundSystem = soundSystem1;
    }
}
