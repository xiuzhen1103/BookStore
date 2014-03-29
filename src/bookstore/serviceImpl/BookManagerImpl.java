package bookstore.serviceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import bookstore.dao.BookDao;
import bookstore.model.Book;
import bookstore.service.BookManager;
@Component("bookManager")
public class BookManagerImpl implements BookManager{
	private BookDao bookDao;

	@Override
	public boolean delete(Integer bookId) throws Exception {
		return bookDao.deleteJob(bookId);
	}

	@Override
	public List<Book> getBooks(Book book) throws Exception {
		return bookDao.getBooks(book);
	}

	@Override
	public void add(Book book) throws Exception {
		bookDao.save(book);
	}

	@Override
	public boolean update(Book book) throws Exception {
		return bookDao.updateBook(book.getBookId(), book.getTitle(), book.getAuthor(), book.getPrice(),book.getQuantity(), book.getCategory(), book.getImagePath());
	}

	public BookDao getBookDao() {
		return bookDao;
	}
	@Resource
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public Book load(Integer bookId) throws Exception {
		// TODO Auto-generated method stub
		return bookDao.loadByBookId(bookId);
	}

	
}
