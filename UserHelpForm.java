import java.util.Scanner;

public class UserHelpForm {
	
	// For FAQ
	public void add_FAQ_form(int FAQ_number) {
		String product;
		String question;
		String answer;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("********** ADD FAQ FORM **********");
		System.out.println("Enter product ");
		product = sc.nextLine();
		System.out.println("Enter question");
		question = sc.nextLine();
		System.out.println("Enter answer");
		answer = sc.nextLine();
		System.out.println("1. Submit\t2.Cancel");
		int choice = sc.nextInt();
		FAQ f = new FAQ(FAQ_number, product, question, answer);
		switch(choice) {
		case 1: submit(f);
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
	
	public void submit(FAQ f) {	
		Datastore.store_FAQ(f);
	}
	
	
	
	
	//For Solution
	public void add_Solution_form(int solution_number) {
		String product;
		String query;
		String solution;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("********** ADD SOLUTION FORM **********");
		System.out.println("Enter product ");
		product = sc.nextLine();
		System.out.println("Enter question");
		query = sc.nextLine();
		System.out.println("Enter answer");
		solution = sc.nextLine();
		Solution s = new Solution(solution_number, product, query, solution);
		System.out.println("1. Submit\t2.Cancel");
		int choice = sc.nextInt();
		switch(choice) {
		case 1: submit(s);
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
	
	public void submit(Solution s) {	
		Datastore.store_solution(s);
	}
	
	public void search_Solution() {

		String product;
		Scanner sc = new Scanner(System.in);
		System.out.println("********** SEARCH SOLUTION FORM **********");
		System.out.println("Enter product");
		product = sc.nextLine();
		Datastore.search_solution(product);
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

	public void add_manual(int manual_number) {
		String product;
		String content;
		Scanner sc = new Scanner(System.in);
		System.out.println("********** ADD MANUAL FORM **********");
		System.out.println("Enter product ");
		product = sc.nextLine();
		System.out.println("Enter content of manual");
		content = sc.nextLine();
		Manual m = new Manual(manual_number, product, content);
		System.out.println("1. Submit\t2.Cancel");
		int choice = sc.nextInt();
		switch(choice) {
		case 1: submit(m);
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

	private void submit(Manual m) {
		Datastore.store_manuals(m);
		
	}

	public void search_manual() {
		String product;
		Scanner sc = new Scanner(System.in);
		System.out.println("********** SEARCH MANUAL FORM **********");
		System.out.println("Enter product");
		product = sc.nextLine();
		Datastore.search_manual(product);
		
	}
	
}
