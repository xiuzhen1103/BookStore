package bookstore.serviceImpl;
<<<<<<< HEAD
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import bookstore.dao.OrderItemDao;
import bookstore.model.OrderItem;
import bookstore.model.Orders;

=======

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import bookstore.dao.OrderItemDao;
import bookstore.model.OrderItem;
<<<<<<< HEAD
import bookstore.model.Orders;
=======
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
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

		return false;
	}

=======
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
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a

	@Resource
	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}

<<<<<<< HEAD
=======
<<<<<<< HEAD

>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a

	@Override
	public List<OrderItem> getOrderItemByOrderId(Integer orderId)
			throws Exception {
		return orderItemDao.getOrderItemByOrderId(orderId);
	}

<<<<<<< HEAD
	@Override
	public boolean delete(OrderItem orderItem) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}


=======
=======
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
}
