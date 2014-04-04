package bookstore.serviceImpl;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
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

	@Override
	public boolean checkUserNameExist(Customer customer)
			throws Exception {
		return customerDao.checkUserNameExist(customer.getUsername());
	}

	@Override
	public Customer getbyId(Customer customer) throws Exception {
		return customerDao.getByCustomerId(customer.getCustomerId());
	}

	@Override
	public boolean update(Customer customer) throws Exception {
		return customerDao.updateCustomer(customer.getCustomerId(), customer.getUsername(),  customer.getName(), customer.getAddress(), customer.getPhone());
	}

	@Override
	public Customer getByUserName(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		return customerDao.getByUserName(customer.getUsername());
	}
	
	

}
