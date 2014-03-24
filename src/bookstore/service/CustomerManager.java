package bookstore.service;

import bookstore.model.Customer;
public interface CustomerManager {
	public boolean login(String username, String password) throws Exception;
	public void add(Customer customer) throws Exception;

}
