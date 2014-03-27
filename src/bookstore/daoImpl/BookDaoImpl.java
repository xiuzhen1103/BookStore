package bookstore.daoImpl;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import bookstore.dao.BookDao;
import bookstore.model.Book;
import bookstore.model.Category;
@Component("bookDao")
public class BookDaoImpl implements BookDao{
	private HibernateTemplate hibernateTemplate; 

	@Override
	public boolean deleteJob(final Integer bookId) throws DataAccessException {
		List<Book> books = hibernateTemplate.find("from Book b where b.bookId = '" + bookId + "'");

		if(books != null && books.size() > 0) {
			hibernateTemplate.executeWithNativeSession(
					new HibernateCallback() {
						@Override
						public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
							return session.createQuery
							("delete Book b where b.bookId='"+ bookId + "'").executeUpdate();
						}					
					});
			return true;
		}
		return false;
	}

	@Override
	public List<Book> getBooks(Book book) throws DataAccessException {
		StringBuffer hql = new StringBuffer();
		Map<String,Object> map = new HashMap<String,Object>();

		hql.append(" from Book b where 1=1 ");
		if(null!=book && book.getBookId()!=null && book.getBookId()!=0)  {
			hql.append(" and b.bookId = :bookId");
			map.put("bookId",+ book.getBookId());
		}

		if(null!=book &&null!=book.getCategory()&&!"".equals(book.getCategory().getCategoryName()))   {
			hql.append(" and LOWER(b.category.categoryName) like LOWER(:categoryName) " );
			map.put("categoryName","%"+ book.getCategory().getCategoryName()+"%");
		}

		if(null!= book &&null!=book.getTitle()&&!"".equals(book.getTitle())) {
			hql.append(" and LOWER(b.title) like LOWER(:title) ");
			map.put("title","%"+ book.getTitle()+"%");
		}

		if(null!=book &&null!=book.getAuthor()&&!"".equals(book.getAuthor())) {
			hql.append(" and LOWER(b.author) like LOWER(:author) " );
			map.put("author","%"+ book.getAuthor()+"%");
		}
		Query query  = this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		if (null != map && map.size() >= 1) {
			Iterator<String> it = map.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				query.setParameter(key, map.get(key));
			}
		}
		
		return query.list();
	}

	@Override
	public void save(Book book) throws DataAccessException  {
		Integer radioList = book.getRadioList();
		 Category category  = (Category) this.hibernateTemplate.load(Category.class, radioList);
		 book.setCategory(category);
		hibernateTemplate.save(book);
		this.hibernateTemplate.flush();
		
	}

	@Override
	public boolean updateBook(Integer bookId, String title, String author,
			Double price, Category category, String imagePath)
			throws DataAccessException {
		Book book = (Book) this.hibernateTemplate.load(Book.class,bookId);
		if(book!=null) {
			book.setTitle(title);
			book.setAuthor(author);
			book.setPrice(price);
			book.setCategory(category);
			book.setImagePath(imagePath);
		}
		return false;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}