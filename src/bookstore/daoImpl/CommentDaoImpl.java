package bookstore.daoImpl;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
<<<<<<< HEAD
=======

import org.apache.struts2.ServletActionContext;
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import bookstore.dao.CommentDao;
import bookstore.model.Book;
import bookstore.model.Comment;
@Component("commentDao")
public class CommentDaoImpl implements CommentDao{
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Comment> getCommentByBookId(Integer bookId)
			throws DataAccessException {
		
		StringBuffer hql = new StringBuffer();
		hql.append( " from Comment c");
		hql.append(" where c.book.bookId =  "+  bookId);
		List<Comment>  list = null;
		try{
			list = 	(List<Comment>)this.hibernateTemplate.find(hql.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	

	@Override
	public void save(Comment comment) throws DataAccessException {
		hibernateTemplate.save(comment);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean updateComment(Integer commentId, Book book, Integer rate,
			String comment) throws DataAccessException {
		Comment c = (Comment) this.hibernateTemplate.load(Comment.class,commentId);
		if(c!=null) {
			c.setBook(book);
			c.setRate(rate);
			c.setComment(comment);
			return true;
		}
		return false;
		
	}

	@Override
	public boolean delete(final Integer commentId) throws DataAccessException {

		List<Comment> books = hibernateTemplate.find("from Comment c where c.commentId = '" + commentId + "'");

		if(books != null && books.size() > 0) {
			hibernateTemplate.executeWithNativeSession(
					new HibernateCallback() {
						@Override
						public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
							return session.createQuery
							("delete Comment c where c.commentId='"+ commentId + "'").executeUpdate();
						}					
					});
			return true;
		}
		return false;
	}

	@Override
	public Comment getCommentById(Integer commentId) throws DataAccessException {
		return (Comment) this.hibernateTemplate.load(Comment.class, commentId);
	}
	
	

}
