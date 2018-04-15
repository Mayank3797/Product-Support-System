import java.util.Scanner;

public class BugReportForm {
	
	String bug_details;
	String product;
	int tech_id;
	boolean resolved;
	
	public BugReportForm(int tech_id) {
		this.tech_id = tech_id;
	}

	public void fill_form() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of product causing problems");
		this.product = sc.nextLine();
		System.out.println("Enter the desciption of the bug");
		this.bug_details = sc.nextLine();
		this.resolved = false;
		System.out.println("1. Submit\t2.Cancel");
		int choice = sc.nextInt();
		switch(choice) {
		case 1: submit();
			break;
		case 2: if(cancel()) {
				System.out.println("Cancelled!");
				return;
			}
			else {
				System.out.println("Back to dashboard!");
				return;
			}
		}
	}
	
	public void submit() {
		BugReport newBugReport = new BugReport(tech_id, bug_details, product, resolved);
		Datastore.store_bug_details(newBugReport);
	}
	
	public boolean cancel() {
		String choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to cancel the form (Y/N)");
		choice = sc.nextLine();
		if(choice.equals("Y")) {
			return true;
		}
		else {
			return false;
		}
	}
}