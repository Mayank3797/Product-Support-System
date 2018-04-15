import java.util.Scanner;

public class TicketForm {
	
	
	Scanner sc = new Scanner(System.in);
	int req_id;
	int t_id;
	
	
	public TicketForm(int req_id, int t_id) {
		this.req_id = req_id;
		this.t_id = t_id;
	}
	
	
	
	public void fill_form() {
		
		String query;
		String priority;
		
		//fill form
		
		System.out.println("Enter query for the ticket");
		query = sc.nextLine();
		System.out.println("Enter priority of the ticket (LOW|MEDIUM|HIGH)");
		priority = sc.nextLine();
		
		//generate_ticket
		Ticket t = new Ticket(t_id, req_id, query, priority);
		Datastore.store_ticket(t);
		
	}
}