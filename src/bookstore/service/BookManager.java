package bookstore.service;
import java.util.List;
import bookstore.model.Book;


public interface BookManager {
	public boolean delete(Integer bookId) throws Exception;
	public void add(Book book) throws Exception;
	public boolean update(Book book) throws Exception;
	public List<Book> getBooks(Book book) throws Exception;

}
