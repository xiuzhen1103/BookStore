package bookstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import bookstore.model.Orders;

public interface OrderDao {

	public void save(Orders order) throws DataAccessException; 
	public boolean deleteOrder(Integer orderId) throws DataAccessException;
	public boolean updateOrder(Orders order) throws DataAccessException;
<<<<<<< HEAD
	public List<Orders> listOrders() throws DataAccessException;
	public List<Orders> listOrdersByCustomerId() throws DataAccessException;
=======
<<<<<<< HEAD
	public List<Orders> listOrders() throws DataAccessException;
	public List<Orders> listOrdersByCustomerId() throws DataAccessException;
=======
	public List<Orders> getOrders(Orders order) throws DataAccessException;
	public List<Orders> getOrders() throws DataAccessException;
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
}
