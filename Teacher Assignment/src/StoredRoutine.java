import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mimtiaze on 20-Aug-16.
 */
public class StoredRoutine implements Serializable{
    public ArrayList<CourseToLinkedListOthersInfo> routines;
    public int alpha;

    public StoredRoutine(){
        alpha=0;
        routines=new ArrayList<>();
    }
}
