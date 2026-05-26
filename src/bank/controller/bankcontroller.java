package bank.controller;


import java.util.List;

import bank.model.BankDAO;
import bank.model.account;
import bank.view.bankview;

public class bankcontroller {

    private BankDAO model;
    private bankview views;

    public bankcontroller(BankDAO model, bankview views) {
        this.model = model;
        this.views = views;
    }

    public void run() {

        while (true) {

            int choice = views.showMenu();

            switch (choice) {

            case 1: {

                String name = views.getname();
                String accountNumber = views.getaccountNumber();
                String pin = views.getpin();
                Double balance = views.getbalance();

                account ac = new account(name, accountNumber, pin, balance);

                int i = model.insert(ac);

                System.out.println(i != 0 ? "Success.." : "Something went wrong..");
            }
                break;

            case 2: {

                int id = views.getid();

                String name = views.getname();
                String accountNumber = views.getaccountNumber();
                String pin = views.getpin();
                Double balance = views.getbalance();

                account ac = new account(id, name, accountNumber, pin, balance);

                int i = model.update(ac);

                System.out.println(i != 0 ? "Success.." : "Something went wrong..");
            }
                break;

            case 3: {

                int id = views.getid();

                int i = model.delete(id);

                System.out.println(i != 0 ? "Success.." : "Something went wrong..");
            }
                break;

            case 4: {

                List<account> list = model.read();

                for (account a : list) {
                    System.out.println(a);
                }
            }
                break;

            case 5: {

                int id = views.getid();
                double amount = views.getbalance();

                model.credit(amount, id);
            }
                break; 

            case 6: {

                int id = views.getid();
                double amount = views.getbalance();

                model.debit(amount, id);
            }
                break;

            case 7: {

                int debitId = views.getdebit();
                int creditId = views.getcredit();

                double amount = views.getbalance();

                model.transfer(amount, debitId, creditId);
            }
                break;

            case 8:
                System.out.println("Exit..");
                return;

            default:
                System.out.println("Invalid choice..");
            }
        }
    }
}