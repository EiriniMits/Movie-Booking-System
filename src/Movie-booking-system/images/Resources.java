
package mainn.images;

import java.net.URL;
/**
 * Επιστρέφει το URL που βρισκεται μια συγκεκτριμένη εικονα
 * @author Μητσοπούλου Ειρήνη
 * @author Παπαδοπούλου Κωνσταντίνα
 * @version 8.0.1 Nov 22, 2014
 */

public class Resources {
    /**
    * Επιστρέφει το URL που βρισκεται μια συγκεκτριμένη εικονα
    * @param imageFilename
    * @return Resources.class.getResource(imageFilename)
    */
    public static URL getURL(String imageFilename) {
        return Resources.class.getResource(imageFilename);        
    }

}
