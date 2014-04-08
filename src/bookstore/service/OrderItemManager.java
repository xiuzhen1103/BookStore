/**
 * 
 */
package bookstore.service;

import java.util.List;

import bookstore.model.OrderItem;

/**
 * @author jack
 *
 */
public interface OrderItemManager {
	public void add(OrderItem orderItem) throws Exception; 
	public boolean update(OrderItem orderItem) throws Exception;
	public List<OrderItem> getOrders(OrderItem orderItem) throws Exception;
	public List<OrderItem> getOrders() throws Exception;
	public boolean delete(OrderItem orderItem) throws Exception;

}
