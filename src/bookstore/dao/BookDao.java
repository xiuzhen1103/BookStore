package bookstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import bookstore.model.Book;
import bookstore.model.Category;

public interface BookDao {

	public boolean deleteJob(Integer bookId) throws DataAccessException;
	public void save(Book book) throws DataAccessException;
	public boolean updateBook(Integer bookId, String title, String author, Double price,Integer quantity,
			Category category, String imagePath) throws DataAccessException;
	public List<Book> getBooks(Book book) throws DataAccessException;

}
