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

import bookstore.dao.CategoryDao;
import bookstore.model.Book;
import bookstore.model.Category;

@Component("categoryDao")
public class CategoryDaoImpl implements CategoryDao{
	private HibernateTemplate hibernateTemplate; 
	@Override
	public boolean deleteCategory(final Integer categoryId)
			throws DataAccessException {
		List<Book> books = hibernateTemplate.find("from Category c where c.categoryId = '" + categoryId + "'");

		if(books != null && books.size() > 0) {
			hibernateTemplate.executeWithNativeSession(
					new HibernateCallback() {
						@Override
						public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
							return session.createQuery
							("delete Category c where c.categoryId='"+ categoryId + "'").executeUpdate();
						}					
					});
			
			return true;
		}
		return false;
	}

	@Override
	public void save(Category category) throws DataAccessException {
		hibernateTemplate.save(category);
		
	}

	@Override
	public boolean updateCategory(Integer categoryId, String categoryName)
			throws DataAccessException {
		Category category = (Category) this.hibernateTemplate.load(Book.class,categoryId);
		if(category!=null) {
			category.setCategoryName(categoryName);
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

	@Override
	public List<Category> getCategorys() throws DataAccessException {
		//return (List<Category>)this.hibernateTemplate.find("from Category");
		StringBuffer hql = new StringBuffer();
		Map<String,Object> map = new HashMap<String,Object>();

		hql.append(" from Category");
		
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
	
	
	

}
