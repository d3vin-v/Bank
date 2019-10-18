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
//		int ewbankAccountNo = bank.createAccount("Mr. Ewbank");
//		int howardAccountNo = bank.createAccount("Mr. Howard");
		int menu;
		int acctNum;
		int newAccountNo = 0;
		//Bank.loadAccounts("file.txt");
		
		do {
			System.out.println("  1. Login with account number \n  2. Create an account \n  3. Quit");
			menu = scan.nextInt();
			scan.nextLine();
			
			switch(menu){
				case 1:
					System.out.println("Please enter your account number: ");
					acctNum = scan.nextInt();
					if(acctNum != 0) { //TODO make this an actual check for existing bank numbers
						System.out.println("Welcome back, " + bank.getAcctName(acctNum) +"\nCurrent balance: $" + bank.checkBalance(acctNum) 
							+ ".00 \n\nWhat action would you like to perform?");
						System.out.println("  1. Make a deposit \n  2. Make a withdrawal \n  3. Close account");
						int menu2 = scan.nextInt();
						scan.nextLine();
						switch(menu2) {
							case 1:
								System.out.println("How much would you like to deposit?");
								int depositN = (int)scan.nextDouble();
								bank.deposit(acctNum, depositN);
								System.out.println("Deposited.\nCurrent balance: $" + bank.checkBalance(acctNum) + ".00");
								break;
							case 2:
								System.out.println("How much would you like to withdraw?");
								int withdrawN = (int)scan.nextDouble();
								bank.withdraw(acctNum, withdrawN);
								System.out.println("Withdrawn.\nCurrent balance: $" + bank.checkBalance(acctNum) + ".00");
								break;
							case 3:
								System.out.println("Are you sure you would like to close your account? This action cannot be undone."
										+ " Y/N:");
								String ans = scan.nextLine();
								if(ans.equals("Y")) {
									bank.closeAccount(acctNum);
								}else {
									System.out.println("Cancelled action");
								}
								break;
							default:
								System.out.println(errors(1));
						}
					}else {
						System.out.println(errors(2));
					}
					break;
				case 2:
					System.out.println("Please enter your name: ");
					String acctName = scan.nextLine();
					newAccountNo = bank.createAccount(acctName);
					System.out.println("Your account number is: " + bank.getAcctNum(acctName));
					break;
				case 3:
					System.out.println("Goodbye.");
					break;
				default:
					System.out.println(errors(1));
			}
			
		}while(menu < 3);
		
//		bank.deposit(ewbankAccountNo, 25);
//		bank.deposit(howardAccountNo, 75);
//
//		bank.checkBalance(ewbankAccountNo);
//		bank.checkBalance(howardAccountNo);
//		
//		bank.withdraw(ewbankAccountNo, 10);
//		bank.closeAccount(howardAccountNo);
//		
//		bank.checkBalance(ewbankAccountNo);
//		bank.checkBalance(howardAccountNo);
		
		scan.close();
	}
	public static String errors(int error) {
		int e = error;
		String errorR = "Error: ";
		if(e == 1) {
			errorR += "unknown action!";
		}else if(e == 2) {
			errorR += "unknown account!";
		}else {
			errorR += "unknown error!";
		}
		return errorR;
	}
}