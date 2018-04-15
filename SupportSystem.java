import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SupportSystem {

	
	static int ticket_count = 0, manual_count = 0;
	static int faq_count = 0, solution_count = 0;
	
	
	// method to generate ticket
	
	public static void generate_ticket(int req_id) {
		
		TicketForm ticket_form = new TicketForm(req_id, ++ticket_count);
		ticket_form.fill_form();
	}		
	
	public static int login() throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email :");
		String email1 = sc.nextLine();
		System.out.println("Enter password :");
		String password1 = sc.nextLine();
		System.out.println("User types :");
		System.out.println("\t1. Requester");
		System.out.println("\t2. Technician");
		System.out.println("\t3. Admin");
		int type = sc.nextInt();
		int login = Datastore.authenticate_login(email1, password1, type);
		if(login != -1) {
			System.out.println("LOGIN SUCCESSFUL :>");
			System.out.println();
			if(type == 1) {
				Requester req = Datastore.requesters.get(login);
				
				req.start_requester();
				
			}
			else if(type == 2) {
				Technician tech = Datastore.technicians.get(login);
				tech.start_technician();
			}
			return login;
		}
		else {
			System.out.println("Error while logging in!");
			System.out.flush();
			return -1;
		}
		
	}

	public static void addInitialData() {
		Requester req = new Requester(false);
		req.userName = "Mayank";
		req.email = "201501040@daiict.ac.in";
		req.password = "12345678";
		req.contact = 9876543210l;
		req.req_id = 1;
		Datastore.requesters.add(req);
		Technician tech = new Technician();
		tech.userName = "Shubham";
		tech.email = "201501020@daiict.ac.in";
		tech.password = "123987654";
		tech.contact = 9876543211l;
		tech.tech_id = 101;
		tech.logged_in = false;
		Datastore.technicians.add(tech);
		
	}

	public static void listAllTickets(int id, int type) {
		if(type == 1) {
			boolean title = false;
			for(Ticket curTicket : Datastore.tickets) {
				if(curTicket.req_id == id) {
					if(!title) {
						System.out.println("Req_id\tQuery\tTicket_ID\tProgress\tPriority");
						title = true;
					}
					System.out.println(curTicket);
				}
			}
		}
		else if(type == 2) {
			boolean title = false;
			for(Ticket curTicket : Datastore.tickets) {
				if(curTicket.tech_id == id) {
					if(!title) {
						System.out.println("Req_id\tQuery\tTicket_ID\tProgress\tPriority\t tech_id");
						title = true;
					}
					System.out.println(curTicket+"   " + id);
				}
			}
		}
		else {
			System.out.println("Inalid User type!");
		}
		
	}

	public static void delete_ticket(int req_id) {
		System.out.println("Enter ticket id");
		Scanner sc = new Scanner(System.in);
		int tid = sc.nextInt();
		Datastore.delete_ticket(tid, req_id);
		return;
		
	}

	public static void delete_ticket_for_tech() {
		System.out.println("Enter ticket id");
		Scanner sc = new Scanner(System.in);
		int tid = sc.nextInt();
		Datastore.delete_ticket(tid);
		return;
		
	}

	public static void sort(int req_id) {
		// More sorting options will be added later
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		for(Ticket ticket : Datastore.tickets) {
			if(ticket.req_id == req_id) {
				tickets.add(ticket);
			}
		}
		Collections.sort(tickets, new Comparator<Ticket> () {
			public int compare(Ticket t1, Ticket t2) {
				return t1.tid - t2.tid;
			}
		});
		display(tickets);
		
	}

	private static void display() {
		for(Ticket ticket : Datastore.tickets) {
			System.out.println(ticket);
		}
		
	}

	public static void filter(int req_id) {
		// More filter options will be added later
		ArrayList<Ticket> dispTickets = new ArrayList<Ticket>();
		for(Ticket ticket : Datastore.tickets) {
			if(ticket.priority.equals("HIGH") && ticket.req_id == req_id) {
				dispTickets.add(ticket);
			}
		}
		display(dispTickets);
	}

	public static void assign_ticket() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the ticket id : ");
		int tid = sc.nextInt();
		System.out.print("Enter technician id : ");
		int tech_id = sc.nextInt();
		Datastore.assign_technician(tid, tech_id);
	}

	private static void display(ArrayList<Ticket> dispTickets) {
		for(Ticket ticket : dispTickets) {
			System.out.println(ticket);
		}
	}

	public static void sortForTech(int tech_id) {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		for(Ticket ticket : Datastore.tickets) {
			if(ticket.tech_id == tech_id) {
				tickets.add(ticket);
			}
		}
		Collections.sort(tickets, new Comparator<Ticket> () {
			public int compare(Ticket t1, Ticket t2) {
				return t1.tid - t2.tid;
			}
		});
		display(tickets);
		
	}

	public static void filterForTech(int tech_id) {
		ArrayList<Ticket> dispTickets = new ArrayList<Ticket>();
		for(Ticket ticket : Datastore.tickets) {
			if(ticket.priority.equals("HIGH") && ticket.tech_id == tech_id) {
				dispTickets.add(ticket);
			}
		}
		display(dispTickets);		
	}

	public static void update_ticket() {
		System.out.println("Enter the ticket details :");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ticket id");
		int tid = sc.nextInt();
		System.out.println("Choose the field that you want to update");
		System.out.println("1. Progress");
		System.out.println("2. Priority");
		System.out.println("3. Query");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter the progress of the ticket");
			int progress = sc.nextInt();
			Datastore.change_details(choice, tid, String.valueOf(progress));
			break;
		case 2: 
			System.out.println("Enter the new priority of ticket");
			String priority = sc.nextLine();
			Datastore.change_details(choice, tid, priority);
			break;
		case 3:
			System.out.println("Enter the updated query for ticket");
			String query = sc.nextLine();
			Datastore.change_details(choice, tid, query);
			break;
		default:
			System.out.println("Invalid Choice");
		}
	}
	
	
	public static void report_bug(int tech_id) {
		
		BugReportForm bug_report_form = new BugReportForm(tech_id);
		bug_report_form.fill_form();
	}

	public static void give_feedback(int req_id) {
		FeedbackForm feedbackForm = new FeedbackForm(req_id);
		feedbackForm.fill_form();
	}

	public static void view_faq() {
		ArrayList<FAQ> faqs = Datastore.faqs;
		for(FAQ faq : faqs) {
			System.out.println("QUESTION : "+faq.question);
			System.out.println("ANSWER : "+ faq.answer);
		}
	}

	public static void add_faq() {
		UserHelpForm user_help_form = new UserHelpForm();
		user_help_form.add_FAQ_form(++faq_count);
		
	}

	public static void add_solution() {
		UserHelpForm user_help_form = new UserHelpForm();
		user_help_form.add_Solution_form(++solution_count);
	}

	public static void add_manual() {
		UserHelpForm user_help_form = new UserHelpForm();
		user_help_form.add_manual(++manual_count);
		
	}

	public static void view_solution() {
		UserHelpForm user_help_form = new UserHelpForm();
		user_help_form.search_Solution();
		
	}

	public static void search_manual() {
		UserHelpForm user_help_form = new UserHelpForm();
		user_help_form.search_manual();
		
	}

	public static void register_new_requester() {
		RegistrationForm registrationForm = new RegistrationForm();
		registrationForm.fill_form();
		
	}
}