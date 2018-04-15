import java.util.Scanner;

public class FeedbackForm {
	
	String feedback_details;
	int rating;
	int req_id;
	int tech_id;
	
	public FeedbackForm(int req_id) {
		super();
		this.req_id = req_id;
	}

	public void fill_form() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your feeback for the Support Service");
		this.feedback_details = sc.nextLine();
		System.out.println("Please rate our service on a scale from 1 to 5");
		this.rating = sc.nextInt();
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
		Feedback feedback = new Feedback(feedback_details, rating, req_id);
		Datastore.store_feedback(feedback);
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