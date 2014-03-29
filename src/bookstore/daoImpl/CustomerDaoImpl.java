package bookstore.daoImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;


import bookstore.dao.CustomerDao;
import bookstore.model.Customer;
@Component("customerDao")
public class CustomerDaoImpl implements CustomerDao{
	private HibernateTemplate hibernateTemplate; 

	public boolean customerAuthentication(String username, String password)
	throws DataAccessException {
		List<Customer> customers = hibernateTemplate.find("from Customer c where c.username='"+username + "' and c.password='"+ password + "'");
		if(customers != null && customers.size() > 0) {
			return true;
		}
		return false;
	}

	public void save(Customer customer) throws DataAccessException {
		hibernateTemplate.save(customer);

	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean checkUserNameExist(String username)
	throws DataAccessException {
		List<Customer> customers = hibernateTemplate.find("from Customer c where c.username = '" + username + "'");
		if(customers != null && customers.size() > 0) {
			return true;
		}
		return false;
	
	}

}
