import java.util.Random;

public class Checking extends Account {
	
	private long debitCardNumber;
	private int debitCardPin;
	
	public Checking(String name, String ssn, double initDeposit) {
		super(name, ssn, initDeposit);
		this.accountNumber = "2" + this.accountNumber;
		setDebitCard();
	}
	
	private void setDebitCard() {
		Random random = new Random();
		this.debitCardNumber = random.nextLong(900000000000L) + 100000000000L;
		this.debitCardPin = random.nextInt(9000) + 1000;
	}
	
	@Override
	public void setRate() {
		this.rate = .15 * getBaseRate();
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Account Type: Checking");
		System.out.println("Debit Card Number: " + this.debitCardNumber);
		System.out.println("Debit Card PIN: " + this.debitCardPin);
		System.out.println("Interest Rate: " + this.rate + "%");
	}
	
}
