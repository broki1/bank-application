import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import utilities.CSV;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<Account> accounts = new LinkedList<Account>();
		
		String file = "C:\\Users\\JusticeEngle\\OneDrive - Xpanxion\\Desktop\\NewBankAccounts.csv";
		
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		
		for(String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String ssn = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.valueOf(accountHolder[3]);
			
			System.out.println(name + ", " + ssn + ", " + accountType + ", $" + initDeposit);
			
			if (accountType.equals("Savings")) {
				
				accounts.add(new Savings(name, ssn, initDeposit));
				
				
			} else if (accountType.equals("Checking")) {
				
				accounts.add(new Checking(name, ssn, initDeposit));
				
			} else {
				
				System.out.println("ERROR READING ACCOUNT TYPE");
				
			}
			
			System.out.println();
		}
		
		for(Account account : accounts) {
			account.showInfo();
			System.out.println();
		}
		
	}

}
