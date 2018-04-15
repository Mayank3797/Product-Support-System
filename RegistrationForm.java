import java.util.Scanner;

public class RegistrationForm {
   
    String email;
    String password;
    String user_name;
    long contact;
    public void fill_form() {
       
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the user name for registering");
        this.user_name = sc.nextLine();
        System.out.println("Enter the email id for registering");
        this.email = sc.nextLine();
        System.out.println("password for the email");
        this.password = sc.nextLine();
        System.out.println("Enter the user contact");
        this.contact = sc.nextLong();
        sc.nextLine();
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
    	Requester newRequester = new Requester(false);
    	newRequester.contact = this.contact;
    	newRequester.email = this.email;
    	newRequester.userName = this.user_name;
    	newRequester.password = this.password;
        Datastore.add_requester(newRequester);
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