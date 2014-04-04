package bookstore.dao;

import org.springframework.dao.DataAccessException;

import bookstore.model.Administrator;

public interface AdministratorDao {
	public boolean adminAuthentication(String username, String password) throws DataAccessException;
	public void save(Administrator admin) throws DataAccessException;
	public Administrator getByUserName(String username) throws DataAccessException;

}
