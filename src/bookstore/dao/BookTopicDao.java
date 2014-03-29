package bookstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import bookstore.model.Book;
import bookstore.model.BookTopic;

public interface BookTopicDao {
	public boolean deleteBookTopic(Integer bookTopicId) throws DataAccessException;
	public void save(BookTopic bookTopic) throws DataAccessException;
	public List<BookTopic> getBookTopics(BookTopic bookTopic) throws DataAccessException;

}
