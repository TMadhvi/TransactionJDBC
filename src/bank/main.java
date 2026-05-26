package bank;

import bank.controller.bankcontroller;
import bank.model.BankDAO;
import bank.view.bankview;

public class main {
	
	public static void main(String[] args) {
		bankview view = new bankview();
		BankDAO dao = new BankDAO();
		bankcontroller cont = new bankcontroller(dao, view);
		
		cont.run();
	}

}
