package bookstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import bookstore.model.Book;
import bookstore.model.Comment;

public interface CommentDao {
	public void save(Comment comment) throws DataAccessException;
	public List<Comment> getCommentByBookId(Integer bookId) throws DataAccessException;
	public boolean updateComment(Integer commentId, Book book, Integer rate,
			String comment) throws DataAccessException;
	public boolean delete(Integer commentId) throws DataAccessException;
	public Comment getCommentById(Integer commentId) throws DataAccessException;

}
