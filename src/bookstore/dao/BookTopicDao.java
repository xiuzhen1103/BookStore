package bookstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import bookstore.model.Book;
import bookstore.model.BookTopic;
import bookstore.model.Category;

public interface BookTopicDao {
	public boolean deleteBookTopic(Integer bookTopicId) throws DataAccessException;
	public void save(BookTopic bookTopic) throws DataAccessException;
	public List<BookTopic> getBookTopics(BookTopic bookTopic) throws DataAccessException;
	public boolean updateBookTopic(Integer bookTopicId,Integer bookId, Integer topicId) throws DataAccessException;

}
