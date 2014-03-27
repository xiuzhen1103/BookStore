package bookstore.dao;
import java.util.List;
import org.springframework.dao.DataAccessException;
import bookstore.model.Category;

public interface CategoryDao {
	
	public boolean deleteCategory(Integer categoryId) throws DataAccessException;
	public void save(Category category) throws DataAccessException;
	public boolean updateCategory(Integer categoryId, String categoryName) throws DataAccessException;
	public List<Category> getCategorys() throws DataAccessException;

}
