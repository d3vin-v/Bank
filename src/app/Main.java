package app;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		example1();
	}
	
	public static void example1()
	{
		Scanner scan = new Scanner(System.in);
		Bank bank = new Bank("Bank of CPHS");
		int ewbankAccountNo = bank.createAccount("Mr. Ewbank");
		int howardAccountNo = bank.createAccount("Mr. Howard");
		int menu;
		String acctNum;
		int newAccountNo = 0;
		int accountNumber;
		
		do {
			System.out.println("1. Login with account number \n2. Create an account");
			menu = scan.nextInt();
			scan.nextLine();
			
			switch(menu){
				case 1:
					System.out.println("Please enter your account number: ");
					acctNum = scan.nextLine();
					break;
				case 2:
					System.out.println("Please enter your name: ");
					String acctName = scan.nextLine();
					scan.nextLine();
					newAccountNo = bank.createAccount(acctName);
					System.out.println("Your account number is: " + bank.getAcctNum());
			}
			
		}while(menu < 6);
		
		bank.deposit(ewbankAccountNo, 25);
		bank.deposit(howardAccountNo, 75);
		bank.deposit(newAccountNo, 100);

		bank.checkBalance(ewbankAccountNo);
		bank.checkBalance(howardAccountNo);
		
		bank.withdraw(ewbankAccountNo, 10);
		bank.closeAccount(howardAccountNo);
		
		bank.checkBalance(ewbankAccountNo);
		bank.checkBalance(howardAccountNo);
		
		scan.close();
	}
}
