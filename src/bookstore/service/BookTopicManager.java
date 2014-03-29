package bookstore.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import bookstore.model.Book;
import bookstore.model.BookTopic;

public interface BookTopicManager {
	public boolean delete(BookTopic bookTopic) throws DataAccessException;
	public void add(BookTopic bookTopic) throws DataAccessException;
	public List<BookTopic> getTopicBooks(BookTopic bookTopic) throws DataAccessException;

}
