package bookstore.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import bookstore.model.Customer;
import bookstore.service.CustomerManager;

@Component("customer")
@Scope("prototype")
public class CustomerAction {
	private Customer customer;
	private CustomerManager customerManager;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CustomerManager getCustomerManager() {
		return customerManager;
	}
	@Resource(name="customerManager")
	public void setCustomerManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}
	
	public String execute() throws Exception{
		customerManager.add(customer);
		return "success";
	}
	
	

}
