
/**
 * Rater is an interface for PlainRater and EfficientRater classes.
 * 
 * @ umashankar
 * @ Version: 1.0 
 */

import java.util.*;

public interface Rater {
    public void addRating(String item, double rating);

    public boolean hasRating(String item);

    public String getID();

    public double getRating(String item);

    public int numRatings();

    public ArrayList<String> getItemsRated();
}
