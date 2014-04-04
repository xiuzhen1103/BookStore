package bookstore.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bookstore.model.Customer;
import bookstore.service.CustomerManager;

@Component("customer")
@Scope("prototype")
public class CustomerAction extends ActionSupport {
	private Customer customer;
	private CustomerManager customerManager;
	private String message ="";
	
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
		if(customerManager.checkUserNameExist(customer)) {
			message = "user name is exist";
			return "fail";
		}
		customerManager.add(customer);
		return "success";
	}
	
	public String isLogin() throws Exception {
		boolean authenticated = customerManager.login(customer.getUsername(), customer.getPassword());
		if (authenticated) {
			message = "login succeeded ";
			customer = customerManager.getByUserName(customer);
			ServletActionContext.getRequest().getSession().setAttribute("customer", customer);
			System.out.println("customerId:" + customer.getCustomerId());
			return "success";
		} else {
			message = "login failed ";
			return "fail";
		}
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String logout() throws Exception {
		ServletActionContext.getRequest().getSession().removeAttribute("customer");
		return "logout";
	}
	public String checkUserNameExist() throws Exception {
		ServletActionContext.getResponse().getWriter().print(customerManager.checkUserNameExist(customer));
		return null;
	}
	
	public String update() throws Exception {
		boolean updated = customerManager.update(customer);
		if(updated) {
			message = "update succeeded";
			return "success";
		}
		else {
			message = "update failed";
			return "fail";
		}
	}
	
	public String get() throws Exception{
		this.customer = this.customerManager.getbyId(customer);
		return "get";
	}

}
