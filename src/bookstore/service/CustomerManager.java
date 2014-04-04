package bookstore.service;

import org.springframework.dao.DataAccessException;

import bookstore.model.Customer;
public interface CustomerManager {
	public boolean login(String username, String password) throws Exception;
	public void add(Customer customer) throws Exception;
	public boolean checkUserNameExist(Customer customer) throws Exception;
	public Customer getbyId(Customer customer) throws Exception;
	public boolean update(Customer customer) throws Exception;
	public Customer getByUserName(Customer customer) throws Exception;
}
