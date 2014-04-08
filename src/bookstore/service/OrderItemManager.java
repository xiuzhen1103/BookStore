
package bookstore.service;
import java.util.List;
import bookstore.model.OrderItem;
import bookstore.model.Orders;

public interface OrderItemManager {
	public void add(OrderItem orderItem) throws Exception; 
	public boolean update(OrderItem orderItem) throws Exception;
	public boolean delete(OrderItem orderItem) throws Exception;

	public List<OrderItem> getOrderItemByOrderId(Integer orderId) throws Exception;


}
