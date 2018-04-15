import java.io.IOException;
import java.util.Scanner;

public class User {
	String userName, email, password;
	long contact;

	/*
	 * private void register() { Scanner sc = new Scanner(System.in);
	 * System.out.println("Enter user name :"); User newUser = new
	 * Requester(-1,false); newUser.userName = sc.nextLine();
	 * System.out.println("Enter email :"); newUser.email = sc.nextLine();
	 * System.out.println("Enter password :"); newUser.password = sc.nextLine();
	 * System.out.println("Enter contact :"); newUser.contact = sc.nextLong();
	 * Datastore.requesters.add((Requester) newUser);
	 * 
	 * }
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		System.out
				.println("-------------WELCOME TO THE PRODUCT SUPPORT SYSTEM-------------");
		do {
			System.out.println("\n\n\n\n\n");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. viewFAQ");
			System.out.println("4. Exit");
			System.out.println("\n\nEnter your choice : ");
			choice = sc.nextInt();
			SupportSystem.addInitialData();
			switch (choice) {
			case 1:
				
				SupportSystem.login();
				break;
			case 2:
				SupportSystem.register_new_requester();
				
				break;
			case 3:
				SupportSystem.view_faq();
				break;
			case 4:
				System.out.println("Exiting the system! Hope to see you again :>");
				break;
			default:
				System.out.println("Invalid Choice");
			}
		} while (choice != 4);
	}


}
