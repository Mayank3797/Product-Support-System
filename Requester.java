import java.util.Scanner;

public class Requester extends User {

	int req_id;
	boolean logged_in;

	public Requester(boolean logged_in) {
		super();
		this.logged_in = logged_in;
	}

	@SuppressWarnings("resource")
	public void start_requester() {
		// TODO Auto-generated method stub

		// user goes on to login into the system
		logged_in = true;
		char choice1;
		while (logged_in) {
			Scanner sc = new Scanner(System.in);
			do {
				Scanner scanner = new Scanner(System.in);
				// Currently contains methods only related to ticketing
				System.out.println("Enter operation number to perform");
				System.out.println("1. Generate a ticket");
				System.out.println("2. Delete a ticket");
				System.out.println("3. Sort tickets");
				System.out.println("4. Filter tickets");
				System.out.println("5. List all tickets");
				System.out.println("6. Give feedback to a technician");
				System.out.println("7. User Help");
				System.out.println("8. Exit");

				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					SupportSystem.generate_ticket(req_id);
					break;
				case 2:
					SupportSystem.delete_ticket(req_id);
					break;

				case 3:
					SupportSystem.sort(req_id);
					break;
				case 4:
					SupportSystem.filter(req_id);
					break;

				case 5:
					SupportSystem.listAllTickets(req_id, 1);
					break;
				case 6:
					SupportSystem.give_feedback(req_id);
					break;
				case 7:
					System.out.println("-------User Help Options-------");
					System.out.println("1. view FAQ");
					System.out.println("2. view Manuals");
					System.out.println("3. Exit user help");
					int choice_for_userHelp_option = sc.nextInt();
					switch(choice_for_userHelp_option) {
					case 1: 
						SupportSystem.view_faq();
						break;
					case 2: SupportSystem.search_manual();
						break;
					}
					break;
				case 8: System.exit(0);
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
				System.out.println("Do you with to continue? [Y/N]");
				sc.nextLine();
				choice1 = sc.nextLine().charAt(0);

			} while (choice1 == 'Y' || choice1 == 'y');

			System.out.println("Do you with to logout? [Y/N]");
			char choice2 = sc.nextLine().charAt(0);
			if (choice2 == 'Y' || choice2 == 'y') {
				logged_in = false;
				return;
			}

			// here use interacts with the support system

			// creating a ticket

		}

	}

}