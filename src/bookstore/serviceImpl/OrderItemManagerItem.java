package bookstore.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import bookstore.dao.OrderItemDao;
import bookstore.model.OrderItem;
<<<<<<< HEAD
import bookstore.model.Orders;
=======
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
import bookstore.service.OrderItemManager;

@Component("orderItemManager")
public class OrderItemManagerItem implements OrderItemManager {
	
	private OrderItemDao orderItemDao;

	@Override
	public void add(OrderItem orderItem) throws Exception {
		orderItemDao.save(orderItem);
	}

	@Override
	public boolean update(OrderItem orderItem) throws Exception {
<<<<<<< HEAD
=======
		// TODO Auto-generated method stub
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
		return false;
	}

	@Override
<<<<<<< HEAD
	public boolean delete(OrderItem orderItem) throws Exception {
=======
	public List<OrderItem> getOrders(OrderItem orderItem) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> getOrders() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(OrderItem orderItem) throws Exception {
		// TODO Auto-generated method stub
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
		return false;
	}

	public OrderItemDao getOrderItemDao() {
		return orderItemDao;
	}

	@Resource
	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}

<<<<<<< HEAD


	@Override
	public List<OrderItem> getOrderItemByOrderId(Integer orderId)
			throws Exception {
		return orderItemDao.getOrderItemByOrderId(orderId);
	}

=======
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
}
