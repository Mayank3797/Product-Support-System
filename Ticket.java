import java.io.Serializable;
import java.util.Date;

public class Ticket implements Serializable{

	int tid;
	int req_id;
	int tech_id;
	String priority;
	Date date_time;
	Date due_date;
	Date turn_around_time;
	String query;
	double progress;
	
	
	public Ticket(int tid, int req_id, String query, String priority) {
		this.tid = tid;
		this.req_id = req_id;
		this.tech_id = -1;
		this.priority = priority;
		this.date_time = new Date();
		this.query = query;
		this.progress = 0;
		
		// set due_date according to priority
		
	}
	
	public void update_techinician(int new_tid) {
		this.tid = new_tid;
	}
	
	/*
	public void put_priority(String priority) {
		this.priority = priority;
	}
	
	public void put_progress(double progress) {
		this.progress = progress;
	}
	
	public void put_query(String query) {
		this.query = query;
	}
	*/
	
	// this will be used to send notifications to the user 
	// for approaching tickets deadline
	public Date get_due_date() {
		return this.due_date;
	}
	@Override
	public String toString() {
		return this.req_id + "\t" + this.query + "\t" + this.tid + "\t" +
				this.progress + "\t" + this.priority; 
		
	}

	
}



