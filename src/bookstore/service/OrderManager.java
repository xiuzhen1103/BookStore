
package bookstore.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import bookstore.model.OrderItem;
import bookstore.model.Orders;

public interface OrderManager {
	public void add(Orders order) throws Exception; 
	public boolean update(Orders order) throws Exception;
	public boolean delete(Orders order) throws Exception;
	public List<Orders> listOrders()throws Exception;
	public List<Orders> getOrdersByCustomerId() throws Exception;
	

}
