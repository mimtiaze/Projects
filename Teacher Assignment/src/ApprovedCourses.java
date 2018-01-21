/**
 * Created by mimtiaze on 01-Jul-16.
 */
public class ApprovedCourses {
    public String approvedName;
    public String approvedCode;
    public String approvedStartTime;
    public String approvedEndTime;
    public String approvedSec;
    public boolean lab;
    public ApprovedCourses next;

    public ApprovedCourses() {
        this.approvedName = "";
        this.approvedCode = "";
        this.approvedStartTime = "";
        this.approvedEndTime = "";
        this.approvedSec = "";
        this.lab = false;
        this.next = null;
    }

    public ApprovedCourses(String approvedName, String approvedCode, String approvedStartTime, String approvedEndTime, String approvedSec, boolean lab) {
        this.approvedName = approvedName;
        this.approvedCode = approvedCode;
        this.approvedStartTime = approvedStartTime;
        this.approvedEndTime = approvedEndTime;
        this.approvedSec = approvedSec;
        this.lab = lab;
        this.next = null;
    }
}
