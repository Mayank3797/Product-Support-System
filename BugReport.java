
public class BugReport {
	String bug_details;
	String product;
	int tech_id;
	boolean resolved;
	public BugReport(int tech_id, String bug_details, String product, boolean resolved) {
		this.tech_id = tech_id;
		this.bug_details = bug_details;
		this.product = product;
		this.resolved = resolved;
	}
}
