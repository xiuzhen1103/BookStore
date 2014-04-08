package bookstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import bookstore.model.OrderItem;

public interface OrderItemDao {

	public void save(OrderItem orderItem) throws DataAccessException; 
	public boolean deleteOrderItem(Integer orderItemId) throws DataAccessException;
	public boolean updateOrderItem(OrderItem orderItem) throws DataAccessException;
	public List<OrderItem> getOrderItem(OrderItem orderItem) throws DataAccessException;
	public List<OrderItem> getOrderItem() throws DataAccessException;
}
