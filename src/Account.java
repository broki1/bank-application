
public abstract class Account implements InterestRate {
	private String name;
	private String ssn;
	private double balance;
	protected String accountNumber;
	protected double rate;
	private static int index = 10000;
	
	public Account(String name, String ssn, double initDeposit) {
		this.name = name;
		this.ssn = ssn;
		this.balance = initDeposit;
		this.accountNumber = this.setAccountNumber();
		index++;
		setRate();
	}
	
	public void compound() {
		double totalInterest = this.balance * (this.rate / 100);
		System.out.println("Total Interest: $" + totalInterest);
		this.balance += totalInterest;
		printBalance();
	}
	
	private String setAccountNumber() {
		String lastTwoOfSSN = this.ssn.substring(this.ssn.length() - 2, this.ssn.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNumber;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}
	
	public void withdraw(double amount) {
		this.balance -= amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		this.balance -= amount;
		System.out.println("Transferring $" + amount + " to " + toWhere);
		printBalance();
	}
	
	public void printBalance() { 
		System.out.println("CURRENT BALANCE: " + this.balance);
	}

	public abstract void setRate();
	
	public void showInfo() {
		System.out.println("Name: " + name + "\nSSN: " + ssn + "\nBalance: " + balance + "\nAccount Number: " + accountNumber
				+ "\nRate: " + rate);
	}
	
	
}
