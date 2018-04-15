import java.util.ArrayList;


public class Datastore {
	static ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	static ArrayList<Requester> requesters = new ArrayList<Requester>();
	static ArrayList<Technician> technicians  = new ArrayList<Technician>();
	static ArrayList<Technician> admins  = new ArrayList<Technician>();
	static ArrayList<Feedback> feedbacks = new ArrayList<Feedback>();
	static ArrayList<BugReport> bugReportDetails = new ArrayList<BugReport>();
	static ArrayList<FAQ> faqs = new ArrayList<FAQ>();
	static ArrayList<Solution> solutions = new ArrayList<Solution>();
	static ArrayList<Manual> manuals = new ArrayList<Manual>();
	static boolean store_ticket(Ticket ticket) {
		tickets.add(ticket);
		return true;
	}
	
	public static void delete_ticket(Ticket ticket) {
		int i;
		if((i = find_tickets(ticket)) != -1) {
			tickets.remove(i);
			System.out.println("ticket successfully removed!");
		}
		else {
			System.out.println("ticket not found!");
		}
	}

	private static int find_tickets(Ticket ticket) {
		for(int i = 0; i < tickets.size(); i++) {
			if(tickets.get(i).tid == ticket.tid) {
				return i;
			}
		}
		
		return -1;
	}
	
	

	private static boolean check_if_technician_exist(int tech_id) {
		for(int i = 0; i < technicians.size(); i++) {
			if(technicians.get(i).tech_id == tech_id) {
				return true;
			}
		}
		return false;
	}
	
	public static void change_details(int choice, int ticket_id, String newValue) {
		int i;
		if((i = find_ticket(ticket_id)) == -1) {
			System.out.println("Ticket not found!");
		}
		switch(choice) {
		case 1: tickets.get(i).progress = Integer.parseInt(newValue);
			break;
		case 2: tickets.get(i).priority = newValue;
			break;
		case 3:
			tickets.get(i).query = newValue;
			break;
		default:
			System.out.println("Invalid choice!");
			return;
		}
		System.out.println("Successfully modified details!");
	}

	private static int find_ticket(int ticket_id) {

		for(int i = 0; i < tickets.size(); i++) {
			if(tickets.get(i).tid == ticket_id) {
				return i;
			}
		}
		
		return -1;
		
	}

	public static int authenticate_login(String user_name, String password, int user_type) {
		/*
		 * user type codes
		 * 1 : Requester
		 * 2 : Technician
		 * 3 : Admin
		 */ 
		if(user_type == 1) {
			for(int i = 0; i < requesters.size(); i++) {
				if(requesters.get(i).email.equals(user_name)) {
					if(requesters.get(i).password.equals(password)) {
						return i;
					}
					else {
						return -1;
					}
				}
			}
		}
		else if(user_type == 2) {
			for(int i = 0; i < technicians.size(); i++) {
				if(technicians.get(i).email.equals(user_name)) {
					if(technicians.get(i).password.equals(password)) {
						return i;
					}
					else {
						return -1;
					}
				}
			}
		}
		else if(user_type == 3) {
			for(int i = 0; i < admins.size(); i++) {
				if(admins.get(i).email.equals(user_name)) {
					if(admins.get(i).password.equals(password)) {
						return i;
					}
					else {
						return -1;
					}
				}
			}
		}
		
		return -1;
	}

	public static void delete_ticket(int tid, int req_id) {
		for(int i = 0;i < tickets.size(); i++) {
			if(tickets.get(i).req_id == req_id && tickets.get(i).tid == tid) {
				tickets.remove(i);
				System.out.println("Ticket deleted successfully!");
				return;
			}
			
		}
		System.out.println("Ticket not found!");
	}

	public static void delete_ticket(int tid) {
		for(int i = 0;i < tickets.size(); i++) {
			if(tickets.get(i).tid == tid) {
				tickets.remove(i);
				System.out.println("Ticket deleted successfully!");
				return;
			}
			
		}
		System.out.println("Ticket not found!");
		
	}

	public static void assign_technician(int tid, int tech_id) {
		int i;
		if((i = find_ticket(tid)) == -1) {
			System.out.println("Ticket not found");
		}
		else if(!check_if_technician_exist(tech_id)) {
			System.out.println("Technician not found");
		}
		else {
			tickets.get(i).tech_id = tech_id;
			System.out.println("Successfully assigned technician!");
		}
		
	}



	public static void store_bug_details(BugReport newBugReport) {
		bugReportDetails.add(newBugReport);
		System.out.println("BUG REPORT RECORDED");
	}

	public static void store_feedback(Feedback feedback) {
		if(feedback.rating <0 || feedback.rating > 5) {
			System.out.println("Invalid Rating!");
			return;
		}
		
		feedbacks.add(feedback);
		System.out.println("FEEDBACK SUCCESSFULLY STORED");
		return;
		
	}
	
	public static void store_FAQ(FAQ faq) {
		faqs.add(faq);
		System.out.println("FAQ SUCCESSFULLY ADDED");
		return;
	}
	
	public static void store_solution(Solution solution) {
		solutions.add(solution);
		System.out.println("SOLUTION ADDED SUCCESSFULLY!");
		return;
	}

	public static void search_solution(String product) {
		System.out.println("Solutions associated with product");
		for(Solution solution : solutions) {
			if(solution.product.equals(product)) {
				System.out.println("QUERY:" + solution.query);
				System.out.println("SOLUTION"+ solution.solution);
				
			}
		}
		
	}

	public static void store_manuals(Manual m) {
		manuals.add(m);
		System.out.println("MANUAL SUCCESSFULLY ADDED");
		return;
	}

	public static void search_manual(String product) {
		System.out.println("Manuals associated with product");
		for(Manual manual: manuals) {
			if(manual.product.equals(product)) {
				System.out.println(manual.manual_number+". "+ manual.product);
				System.out.println(manual.content);
			}
		}
	}

	public static void add_requester(Requester newRequester) {
		newRequester.req_id = requesters.size();
		for(Requester req : requesters) {
			if(req.email.equals(newRequester.req_id)) {
				System.out.println("Error : EMAIL IS ALREADY REGISTERED!");
				return;
			}
		}
		requesters.add(newRequester);
		System.out.println("USER SUCCESSFULLY ADDED");
		return;
	}
}
