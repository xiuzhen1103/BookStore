package bookstore.dao;

import org.springframework.dao.DataAccessException;

import bookstore.model.Book;
import bookstore.model.Category;
import bookstore.model.Customer;

public interface CustomerDao {
	public boolean customerAuthentication(String username, String password) throws DataAccessException;
	public void save(Customer customer) throws DataAccessException;
	public boolean checkUserNameExist(String username) throws DataAccessException; 
	public boolean updateCustomer(Integer customerId, String username, String name,
			String address, String phone) throws DataAccessException;
	public Customer getByCustomerId(Integer customerId) throws DataAccessException;
	public Customer getByUserName(String username) throws DataAccessException;

}
