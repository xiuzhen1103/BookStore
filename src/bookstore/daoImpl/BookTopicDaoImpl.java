package bookstore.daoImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import bookstore.dao.BookTopicDao;
import bookstore.model.Book;
import bookstore.model.BookTopic;
import bookstore.model.Topic;
@Component("bookTopicDao")
public class BookTopicDaoImpl implements BookTopicDao{
	private HibernateTemplate hibernateTemplate; 
	private Book book;

	@Override
	public boolean deleteBookTopic(final Integer bookTopicId)
			throws DataAccessException {
		List<Book> books = hibernateTemplate.find("from BookTopic b where b.bookTopicId = '" + bookTopicId + "'");

		if(books != null && books.size() > 0) {
			hibernateTemplate.executeWithNativeSession(
					new HibernateCallback() {
						@Override
						public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
							return session.createQuery
							("delete BookTopic b where b.bookTopicId='"+ bookTopicId + "'").executeUpdate();
						}					
					});
			
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void save(BookTopic bookTopic) throws DataAccessException {
		List<Integer> bookTopics = new ArrayList<Integer>();
		
		List<Topic> topics = hibernateTemplate.find("select name t from Topic t, BookTopic bt"
				+ " where t.topicId = bt.topic.topicId and bt.book.bookId = " + book.getBookId());
		
		for (Topic topic : topics) {
			bookTopics.add(topic.getTopicId());
		}
		Integer[] checkboxList = bookTopic.getCheckboxes();
		
		for(int i=0; i < checkboxList.length;i++) {
			if (!bookTopics.contains(checkboxList[i])) {
				BookTopic  s= new BookTopic();
				Topic sc =  (Topic) this.hibernateTemplate.load(Topic.class, checkboxList[i]);
				s.setTopic(sc);
				s.setBook(book);
				hibernateTemplate.save(s);
			}
		}
		
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookTopic> getBookTopics(BookTopic bookTopic)
			throws DataAccessException {
		return (List<BookTopic>)this.hibernateTemplate.find("from BookTopic");
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	

}
