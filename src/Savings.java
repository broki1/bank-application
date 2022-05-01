import java.util.Random;

public class Savings extends Account {
	
	private int safetyDepositBoxId;
	private int safetyDepositBoxKey;
	
	public Savings(String name, String ssn, double initDeposit) {
		super(name, ssn, initDeposit);
		this.accountNumber = "1" + this.accountNumber;
		setSafetyDepositBox();
	}
	
	private void setSafetyDepositBox() {
		Random random = new Random();
		this.safetyDepositBoxId = random.nextInt(900) + 100;
		this.safetyDepositBoxKey = random.nextInt(9000) + 1000;
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Account Type: Savings");
		System.out.println("Safety Deposit Box ID: " + this.safetyDepositBoxId);
		System.out.println("Safety Deposit Box Key: " + this.safetyDepositBoxKey);
		System.out.println("Interest Rate: " + this.rate + "%");
	}

	@Override
	public void setRate() {
		this.rate = getBaseRate() - .25;
	}
	
}
