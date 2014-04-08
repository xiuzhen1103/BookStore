package bookstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import bookstore.model.OrderItem;

public interface OrderItemDao {

	public void save(OrderItem orderItem) throws DataAccessException; 
	public boolean deleteOrderItem(Integer orderItemId) throws DataAccessException;
	public boolean updateOrderItem(OrderItem orderItem) throws DataAccessException;
<<<<<<< HEAD
	public List<OrderItem> getOrderItemByOrderId(Integer orderId)throws DataAccessException;
=======
	public List<OrderItem> getOrderItem(OrderItem orderItem) throws DataAccessException;
	public List<OrderItem> getOrderItem() throws DataAccessException;
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
}
