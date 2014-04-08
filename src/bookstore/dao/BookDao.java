package bookstore.dao;
import java.util.List;
import org.springframework.dao.DataAccessException;
import bookstore.model.Book;
import bookstore.model.Category;

public interface BookDao {

	public boolean deleteBook(Integer bookId) throws DataAccessException;
	public void save(Book book) throws DataAccessException;
	public boolean updateBook(Integer bookId, String title, String author, Double price,Integer quantity,
			Category category, String imagePath) throws DataAccessException;
	public List<Book> getBooks(Book book) throws DataAccessException;
	public Book getByBookId(Integer bookId) throws DataAccessException;
	public boolean updateBook(Book book) throws DataAccessException;
<<<<<<< HEAD
	public List<Book> sortBookByParam(String sort) throws DataAccessException;
	public List<Book> sortBookByParam2(String sort);
=======
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9

}
