package bookstore.service;

import bookstore.model.Administrator;
public interface AdministratorManager {
	public boolean login(String username, String password) throws Exception;
	public void add(Administrator admin) throws Exception;

}
