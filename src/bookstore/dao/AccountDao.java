package bookstore.dao;

import org.springframework.dao.DataAccessException;

import bookstore.model.Account;

public interface AccountDao {

	public void save(Account account) throws DataAccessException; 

}
