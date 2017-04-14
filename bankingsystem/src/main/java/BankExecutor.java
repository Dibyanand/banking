import com.bank.exceptions.InsufficientBalanceException;
import com.bank.exceptions.InsufficientInitialBalanceException;
import com.bank.exceptions.InvalidAccountNumberException;
import com.bank.model.Account;
import com.bank.service.AccountService;
import com.bank.service.AccountServiceImpl;

public class BankExecutor {

	public static void main(String[] args) {
		
		AccountService accountService=new AccountServiceImpl();
        try {
			Account account=accountService.createAccount("Dibyanand", 500);
			System.out.println("Account Created successfully and Your account no is : "+account.getAccountNumber());
			accountService.printAccountInfo(account.getAccountNumber());
			
			System.out.println("Going to deposite Amount ....");
			accountService.depositeAmount(account.getAccountNumber(),1000);
			System.out.println("After deposited Amount.. statements: ");
			accountService.printAccountInfo(account.getAccountNumber());
			System.out.println("Going to withdraw Amount ....");
			accountService.withdrawAmount(account.getAccountNumber(), 100);
			System.out.println("After withdraw Amount.. statements: ");
			accountService.printAccountInfo(account.getAccountNumber());
			
			//Creating another account
			Account account1=accountService.createAccount("Anand", 5000);
			System.out.println("Account Created successfully and Your account no is : "+account1.getAccountNumber());
			accountService.printAccountInfo(account1.getAccountNumber());
			
			System.out.println("Going to deposite Amount ....");
			accountService.depositeAmount(account1.getAccountNumber(),1000);
			System.out.println("After deposited Amount.. statements: ");
			accountService.printAccountInfo(account1.getAccountNumber());
			System.out.println("Going to withdraw Amount ....");
			accountService.withdrawAmount(account1.getAccountNumber(), 100);
			System.out.println("After withdraw Amount.. statements: ");
			accountService.printAccountInfo(account1.getAccountNumber());
			
			
		} catch (InsufficientInitialBalanceException e) {
			System.out.println(e);
		} catch (InvalidAccountNumberException e) {
			System.out.println(e);
		} catch (InsufficientBalanceException e) {
			System.out.println(e);
		}
        
        
        
	}

}
