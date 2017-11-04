
package mainn;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Περιεχει τα κοινα χαρακτηριστικα μιας ταινιας και μιας θεατρικης παραστασης
 * @author Μητσοπούλου Ειρήνη
 * @author Παπαδοπούλου Κωνσταντίνα
 * @version 8.0.1 Nov 22, 2014
 */
public class Show implements Serializable{
    private String showName;
    private String showDescription;
    private String director;
    private String actorList;
    private final ArrayList<String> date = new ArrayList<>();
    private final int price;
     /**
     * @param showName1
     * @param showDescription1
     * @param director1
     * @param actorList1
     * @param date1
     * @param price1
     * */
    public Show(String showName1,String showDescription1,String director1,String actorList1,String []date1,int price1){
        showName = showName1;
        showDescription = showDescription1;
        director = director1;
        actorList = actorList1;
        int i;
        for(i=0;i<20;i++){                     
                date.add(date1[i]);    
        }
        price = price1;
    }
    
    /**
    * Επιστρεφει το ονομα της ταινιας/θεατρικη παραστασης
    * @return showName
    **/
    public String getshowName(){
        return showName;
    }
    /**
    * Aλλαζει το ονομα της ταινιας/θεατρικη παραστασης
    * @param name1
    **/
    public void changeshowName(String name1){
        showName = name1;
    }
    
    /**
    * Επιστρεφει την περιγραφη της ταινιας/θεατρικη παραστασης
    * @return showDescription
    **/
    public String getshowDescription(){
        return showDescription;
    }
    /**
    * Aλλαζει την περιγραφη της ταινιας/θεατρικη παραστασης
    * @param description1
    **/
    public void changeshowDescription(String description1){
        showDescription = description1;
    }
    
    /**
    * Επιστρεφει τον σκηνοθετη
    * @return director
    **/
    public String getDirector(){
        return director;
    }
    /**
    * Aλλαζει τον σκηνοθετη
    * @param director1
    **/
    public void changeDirector(String director1){
        director = director1;
    }
    
    /**
    * Επιστρεφει τη λιστα με τους ηθοποιους
    * @return actorList
    **/
    public String getactorList(){
        return actorList;
    }
    /**
    * Aλλαζει τη λιστα με τους ηθοποιους
    * @param actorList1
    **/
    public void changeactorList(String actorList1){
        actorList = actorList1;
    }
    
    /**
    * Επιστρεφει την μερα που παιζεται η ταινια/θεατρικη παρασταση
    * @return date1
    **/
    public String[] getDate(){
        int i;
        String[] date1 = new String[20];
        for(i=0;i<20;i++){
            date1[i] = date.get(i);
        }   
        return date1;
    }
    
    
    /**
    * Επιστρεφει την τιμη των εισητηριων της ταινιας/θεατρικη παραστασης
    * @return price
    **/
    public int getPrice(){
        return price;
    }
}
