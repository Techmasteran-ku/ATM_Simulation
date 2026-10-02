import java.util.Scanner;

class Account_Holder {
	
	String holderName = "Ankush Kedar";
	String holderEmail = "ankushkedar@gmail.com";
	String holderAddress = "At post aamkheda soyegaon chatrapati sambhajinagar, maharastra, india-431120";
	
	long holderMobile = 9637191742L;
	
	double balance = 10000;
	int minBalance = 2000;
	
	long accountNo = 8010142838L;
	int pin = 6452;
}

class ATM extends Account_Holder{
	
	Scanner Sc = new Scanner(System.in);
//	ATM obj = new ATM();
	
	
	void login() {
		
		int loginAttempts = 3;
		int failedAttempts = 0;
		
		while(true) {
			
			if(failedAttempts == 3) {
				System.out.println("Account Banned: You Reached Your Maximum Failed Attempts Limit.");
				break;
			}
			
			System.out.println("You have " + loginAttempts + " login Attempts!");
			System.out.print("Enter Your Account Number: ");
			long accountNo = Sc.nextLong();
			System.out.print("Enter Your Pin: ");
			int pin = Sc.nextInt();
			System.out.println();
			
			if(this.accountNo == accountNo && this.pin == pin) {
				System.out.println("Login Successfull...");
				this.showMenu();
				break;
			}
			else {
				--loginAttempts;
				++failedAttempts;
				
				if(loginAttempts >= 1) {
					System.out.println("Invalid Account Number or Pin, Please Enter Valid One");
					System.out.println("Worring: Only " + loginAttempts + " login Attempts Remaining!");
					}
				
				else {
					System.out.print("Invalid Account Number or Pin");
				}
			}
			System.out.println();
		}
	}

	int withdraw() {
		
		System.out.print("Enter Withdraw Amount: ");
		double withAmount = Sc.nextDouble();
		
		if((balance - withAmount) < minBalance) {
			System.out.println("You should maintain minimum balance, Cannot withdrawable");
		}
		else {
			balance -= withAmount;
			System.out.println("Successfully withdraw " + withAmount + " Rs.");
		}
		this.showMenu();
		
		return 0;
	}
	
	int deposit() {
		
		System.out.print("Enter Deposit Amount: ");
		double depAmount = Sc.nextDouble();
		
		if(depAmount <= 0) {
			System.out.println("Invalid amount, please enter valid amount for deposit");
		}
		else {
			balance += depAmount;
			System.out.println("Successfully deposit " + depAmount + " Rs.");
		}
		this.showMenu();
		
		return 0;
	}
	
	int checkBalance() {
		System.out.println("Your current account balance is " + balance + " Rs.");
		this.showMenu();
		
		return 0;
	}
	
	int viewAccount() {
//		ATM obj = new ATM();
		
		System.out.println("Account Holder's Name: " + holderName);
		System.out.println("Account Number: " + accountNo);
		System.out.println("Account Holder's Remaining Balance: " + balance);
		System.out.println("Account Holder's Mobile Number: " + holderMobile);
		System.out.println("Account Holder's Email: " + holderEmail);
		System.out.println("Account Holder's Address: " + holderAddress);
		this.showMenu();
		
		System.out.println();
		return 0;
	}
	
	int logout() {
		this.login();
		
		System.out.println();
		return 0;
	}
	
	int showMenu() {
		
		System.out.println();
		System.out.println("1. Withdraw");
		System.out.println("2. Deposit");
		System.out.println("3. Check Balance");
		System.out.println("4. View Account");
		System.out.println("5. Logout");
		System.out.println("6. Exit");
		
		 System.out.print("Enter Your Choice: ");
		 int choice = Sc.nextInt();
		 System.out.println();
		 
		switch(choice) {
		case 1:
			this.withdraw();
			break;
		case 2:
			this.deposit();
			break;
		case 3:
			this.checkBalance();
			break;
		case 4:
			this.viewAccount();
			break;
		case 5:
			this.logout();
			break;
		case 6:
			System.out.println("Exit Successfull...!");
			break;
		default:
			System.out.println("Invalid Input, Please Enter Valid Input...");
			this.showMenu();
		}
		
		System.out.println();
		return 0;
	}
	
		
	
}


public class ATM_simulation {

	public static void main(String[] args) {
		ATM obj = new ATM();
		obj.login();
	}
}
