package bookstore.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import bookstore.dao.BookTopicDao;
import bookstore.model.Book;
import bookstore.model.BookTopic;
import bookstore.service.BookTopicManager;
@Component("bookTopicManager")
public class BookTopicManagerImpl implements BookTopicManager{
	private BookTopicDao bookTopicDao;

	@Override
	public boolean delete(BookTopic bookTopic) throws DataAccessException {
		return bookTopicDao.deleteBookTopic(bookTopic.getBookTopicId());
	}

	@Override
	public void add(BookTopic bookTopic) throws DataAccessException {
		bookTopicDao.save(bookTopic);
		
	}

	public BookTopicDao getBookTopicDao() {
		return bookTopicDao;
	}
	@Resource
	public void setBookTopicDao(BookTopicDao bookTopicDao) {
		this.bookTopicDao = bookTopicDao;
	}

	@Override
	public List<BookTopic> getTopicBooks(BookTopic bookTopic) throws DataAccessException {
		// TODO Auto-generated method stub
		return bookTopicDao.getBookTopics(bookTopic);
	}
	
	
	

}
