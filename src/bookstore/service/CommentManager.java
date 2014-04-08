package bookstore.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import bookstore.model.Book;
import bookstore.model.Comment;

public interface CommentManager {
	public void add(Comment comment) throws Exception;

	public boolean updatet(Comment comment) throws Exception;
	public boolean delete(Comment comment) throws Exception;
	public Comment get(Comment comment) throws Exception;
	public List<Comment> getByBookId(Integer bookId) throws DataAccessException;
	

}
