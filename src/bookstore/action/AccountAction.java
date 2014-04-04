package bookstore.action;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import bookstore.model.Account;
import bookstore.model.Customer;
import bookstore.service.AccountManager;

@Component("account")
@Scope("prototype")
public class AccountAction {
	private Account account = new Account();
	private AccountManager accountManager;
	private List<Account> accounts;
	private String message="";
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public AccountManager getAccountManager() {
		return accountManager;
	}
	@Resource(name="accountManager")
	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String list() throws Exception {
		this.accounts = accountManager.getAccountbyCustomerId(this.account);
		return "list";	
	}
	
	public String execute() throws Exception{
		account.setCustomer(getCustomerFromSession());
		accountManager.add(this.account);
		return "success";
	}
	
	public String delete() throws Exception{
		boolean deleted = accountManager.delete(account);
		if(deleted) {
			message="delete succeeded";
			return "success";
		}
		else {
			message = "delete failed, Employer id is not exist";
			return "fail";
		}
	}
	
	public String update() throws Exception {
		boolean updated = accountManager.update(account);
		if(updated) {
			message = "update succeeded";
			return "success";
		}
		else {
			message = "update failed";
			return "fail";
		}
	}
	
	public String get() throws Exception{
		this.account = accountManager.getByAccountId(account);
		return "get";
	}
	
	 private Customer getCustomerFromSession() {
	        return (Customer) ServletActionContext.getRequest().getSession().getAttribute("customer");
	    }
	 

	

}
