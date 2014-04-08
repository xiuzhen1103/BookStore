package bookstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import bookstore.model.Orders;

public interface OrderDao {

	public void save(Orders order) throws DataAccessException; 
	public boolean deleteOrder(Integer orderId) throws DataAccessException;
	public boolean updateOrder(Orders order) throws DataAccessException;
	public List<Orders> listOrders() throws DataAccessException;
	public List<Orders> listOrdersByCustomerId() throws DataAccessException;
}
