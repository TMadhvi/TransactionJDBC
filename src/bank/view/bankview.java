package bank.view;

import java.util.Scanner;

public class bankview {
	
private Scanner sc = new Scanner(System.in);
	
	
	public int showMenu() {
		System.out.println("Enter 1 for insert :");
		System.out.println("Enter 2 for update :");
		System.out.println("Enter 3 for delete :");
		System.out.println("Enter 4 for read :");
		System.out.println("Enter 5 for Credit :");
		System.out.println("Enter 6 for Debit :");
		System.out.println("Enter 7 for Transcation..... :");
		System.out.println("Enter 8 exit :");

		System.out.println("..............................................................");
	
    return sc.nextInt();
	}
	
	public int getdebit() {
		System.out.println("Enter Debit ID");
		return sc.nextInt();
	}
	
	public int getcredit() {
		System.out.println("Enter CREDIT ID");
		return sc.nextInt();
	}
		
	
	public int getid() {
		System.out.println("Enter tha ID");
		return sc.nextInt();
		
	}
	public String getname() {
		sc.nextLine();
		System.out.println("Enter tha Name");
		return sc.nextLine();
		
	}
	public String getaccountNumber() {
		System.out.println("Enter tha Account Number");
		return sc.nextLine();
		
	}
	public String getpin() {
		System.out.println("Enter tha PIN");
		return sc.nextLine();
		
	}
	public double getbalance() {
		System.out.println("Enter tha BALANCE");
		return sc.nextDouble();
		
	}
	

}
