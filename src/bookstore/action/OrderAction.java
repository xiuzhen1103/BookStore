package bookstore.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import bookstore.model.Orders;
import bookstore.service.OrderManager;

import com.opensymphony.xwork2.ActionSupport;
@Component("order")
@Scope("prototype")
public class OrderAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private OrderManager orderManager;
	private Orders order;
	private List<Orders> orders;
	public OrderManager getOrderManager() {
		return orderManager;
	}
	@Resource(name="orderManager")
	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public String list() throws Exception {
		this.orders = orderManager.listOrders();
		return "list";	
	}
	
	public String listByCustomerId() throws Exception {
		this.orders = orderManager.getOrdersByCustomerId();
		return "listByCustomerId";	
	}
	

	
	

}
