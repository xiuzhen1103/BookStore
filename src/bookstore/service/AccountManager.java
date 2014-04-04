package bookstore.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import bookstore.model.Account;

public interface AccountManager {
	public void add(Account account) throws Exception; 
		public boolean update(Account account) throws Exception;
		public List<Account> getAccounts(Account account) throws Exception;
		public Account getByAccountId(Account account) throws Exception;
		public List<Account> getAccountbyCustomerId(Account account) throws Exception;
		public boolean delete(Account account) throws Exception;

	
}

