package bookstore.dao;

import org.springframework.dao.DataAccessException;

import bookstore.model.Customer;

public interface CustomerDao {
	public boolean customerAuthentication(String username, String password) throws DataAccessException;
	public void save(Customer customer) throws DataAccessException;
	public boolean checkUserNameExist(String username) throws DataAccessException; 

}
