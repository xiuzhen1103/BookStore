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
		return bookDao.deleteBook(bookId);
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
		return bookDao.updateBook(book);
	}

	public BookDao getBookDao() {
		return bookDao;
	}
	@Resource
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public Book get(Integer bookId) throws Exception {
		Book book = bookDao.getByBookId(bookId);
		return book; 
<<<<<<< HEAD

=======
<<<<<<< HEAD
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
	}
	@Override
	public List<Book> sortBookByParam(String sort) throws Exception {
		return bookDao.sortBookByParam(sort);
	}

	@Override
	public List<Book> sortBookByParam2(String sort) {
		return bookDao.sortBookByParam2(sort);
<<<<<<< HEAD

=======
=======
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
	}

	
}
