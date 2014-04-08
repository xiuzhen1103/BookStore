/**
 * 
 */
package bookstore.service;

import java.util.List;

import bookstore.model.Orders;

/**
 * @author jack
 *
 */
public interface OrderManager {
	public void add(Orders order) throws Exception; 
	public boolean update(Orders order) throws Exception;
	public List<Orders> getOrders(Orders order) throws Exception;
	public List<Orders> getOrders() throws Exception;
	public boolean delete(Orders order) throws Exception;

}
