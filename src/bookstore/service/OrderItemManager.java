<<<<<<< HEAD

package bookstore.service;
import java.util.List;
import bookstore.model.OrderItem;
import bookstore.model.Orders;

public interface OrderItemManager {
	public void add(OrderItem orderItem) throws Exception; 
	public boolean update(OrderItem orderItem) throws Exception;
	public boolean delete(OrderItem orderItem) throws Exception;

	public List<OrderItem> getOrderItemByOrderId(Integer orderId) throws Exception;


=======
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

>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
}
