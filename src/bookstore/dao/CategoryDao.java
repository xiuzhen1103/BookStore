package bookstore.dao;
import java.util.List;
import org.springframework.dao.DataAccessException;
import bookstore.model.Category;
import bookstore.model.Customer;

public interface CategoryDao {
	
	public boolean deleteCategory(Integer categoryId) throws DataAccessException;
	public void save(Category category) throws DataAccessException;
	public boolean updateCategory(Integer categoryId, String categoryName) throws DataAccessException;
	public List<Category> getCategorys() throws DataAccessException;
	public Category getById(Integer categoryId) throws DataAccessException;

}
