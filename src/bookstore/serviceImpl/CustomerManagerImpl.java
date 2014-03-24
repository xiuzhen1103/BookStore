package bookstore.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import bookstore.dao.CustomerDao;
import bookstore.model.Customer;
import bookstore.service.CustomerManager;
@Component("customerManager")
public class CustomerManagerImpl implements CustomerManager {
	private CustomerDao customerDao;

	public void add(Customer customer) throws Exception {
		customerDao.save(customer);
	}

	public boolean login(String username, String password) throws Exception {
		return customerDao.customerAuthentication(username, password);
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}
	@Resource
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	

}
