package bookstore.service;
import java.util.List;

import org.springframework.dao.DataAccessException;

import bookstore.model.Category;


public interface CategoryManager {
	public boolean delete(Category category) throws Exception;
	public void add(Category category) throws Exception;
	public boolean update(Category category) throws Exception;
	public List<Category> getCategorys() throws Exception;

}
