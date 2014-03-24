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
		List<Customer> admins = hibernateTemplate.find("from Customer c where c.username='"+username + "' and a.password='"+ password + "'");
		if(admins != null && admins.size() > 0) {
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

}
