<<<<<<< HEAD

=======
/**
 * 
 */
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
package bookstore.service;

import java.util.List;

<<<<<<< HEAD
import org.springframework.dao.DataAccessException;

import bookstore.model.OrderItem;
import bookstore.model.Orders;

public interface OrderManager {
	public void add(Orders order) throws Exception; 
	public boolean update(Orders order) throws Exception;
	public boolean delete(Orders order) throws Exception;
	public List<Orders> listOrders()throws Exception;
	public List<Orders> getOrdersByCustomerId() throws Exception;
	
=======
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
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9

}
