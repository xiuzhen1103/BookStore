package bookstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import bookstore.model.Account;

public interface AccountDao {

	public void save(Account account) throws DataAccessException; 
	public boolean deleteAccount(Integer accountId) throws DataAccessException;
	public boolean updateAccount(Integer accountId, String shippingAddress, String paymentMethod,Double balance) throws DataAccessException;
	public List<Account> getAccounts(Account account) throws DataAccessException;
	public Account getByAccountId(Integer accountId) throws DataAccessException;
	public List<Account> getAccountbyCustomerId(Account account) throws DataAccessException;
	public boolean updateAccount(Account account) throws DataAccessException;

}
