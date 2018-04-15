import java.util.Scanner;

public class Technician extends User {

	int tech_id;
	boolean logged_in = true;

	public void start_technician() {

		this.logged_in = true;

		while (logged_in) {
			Scanner sc = new Scanner(System.in);
			char choice1;
			do {

				// Currently contains methods only related to ticketing
				System.out.println("Enter operation number to perform");
				System.out.println("1. Generate a ticket");
				System.out.println("2. Delete a ticket");
				System.out.println("3. Assign a ticket");
				System.out.println("4. Update a ticket");
				System.out.println("5. Sort tickets");
				System.out.println("6. Filter tickets");
				System.out.println("7. List all tickets");
				System.out.println("8. Report a bug");
				System.out.println("9. User help");
				int choice = sc.nextInt();
				sc.nextLine();
				
				switch (choice) {
				case 1:
					SupportSystem.generate_ticket(this.tech_id);
					break;

				case 2:
					SupportSystem.delete_ticket_for_tech();
					break;

				case 3:
					SupportSystem.assign_ticket();
					break;

				case 4:
					SupportSystem.update_ticket();
					break;

				case 5:
					SupportSystem.sortForTech(tech_id);
					break;
				case 6:
					SupportSystem.filterForTech(tech_id);
					break;
				case 7:
					SupportSystem.listAllTickets(tech_id, 2);
					break;
				case 8:
					SupportSystem.report_bug(tech_id);
					break;
				case 9:
					System.out.println("-------User Help Options-------");
					System.out.println("1. view FAQ");
					System.out.println("2. view Manuals");
					System.out.println("3. add FAQ");
					System.out.println("4. add solution");
					System.out.println("5. add manual");
					System.out.println("6. view solution");
					System.out.println("7. Exit user help");
					int choice_for_userHelp_option = sc.nextInt();
					sc.nextLine();
					
					switch (choice_for_userHelp_option) {
					case 1:
						SupportSystem.view_faq();
						break;
					case 2: 
						SupportSystem.search_manual();
						break;
					case 3:
						SupportSystem.add_faq();
						break;
					case 4:
						SupportSystem.add_solution();
						break;
					case 5:
						SupportSystem.add_manual();
						break;
					case 6:
						SupportSystem.view_solution(); 
					}
					break;
				
				default:
					System.out.println("Invalid choice");
					break;
				}
				System.out.println("Do you with to continue? [Y/N]");
				choice1 = sc.nextLine().charAt(0);

			} while (choice1 == 'Y' || choice1 == 'y');

			System.out.println("Do you with to logout? [Y/N]");
			char choice2 = sc.nextLine().charAt(0);
			if (choice2 == 'Y' || choice2 == 'y') {
				logged_in = false;
			}
			// sc.close();
		}

	}

}