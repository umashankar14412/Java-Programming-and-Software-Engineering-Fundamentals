
import java.util.*;

public class TitleAndDepthComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        if (q1.getInfo().compareTo(q2.getInfo()) < 0) {
            return -1;
        } else if (q1.getInfo().compareTo(q2.getInfo()) > 0) {
            return 1;
        } else {
            return Double.compare(q1.getDepth(), q2.getDepth());
        }
    }
}
