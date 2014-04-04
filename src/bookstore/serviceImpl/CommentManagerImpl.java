package bookstore.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import bookstore.dao.CommentDao;
import bookstore.model.Book;
import bookstore.model.Comment;
import bookstore.service.CommentManager;

@Component("commentManager")
public class CommentManagerImpl implements CommentManager{
	private CommentDao commentDao;

	@Override
	public void add(Comment comment) throws DataAccessException {
		commentDao.save(comment);
		
	}

	@Override
	public boolean delete(Comment comment) throws DataAccessException {
		return commentDao.delete(comment.getCommentId());
	}

	@Override
	public List<Comment> getByBookId(Book book) throws DataAccessException {
		return  commentDao.getCommentByBookId(book.getBookId());
	}

	@Override
	public boolean updatet(Comment comment) throws DataAccessException {
		return commentDao.updateComment(comment.getCommentId(), comment.getBook(), comment.getRate(), comment.getComment());
	}

	public CommentDao getCommentDao() {
		return commentDao;
	}
	@Resource
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public Comment get(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		return commentDao.getCommentById(comment.getCommentId());
	}
	

}
