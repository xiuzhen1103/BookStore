package bookstore.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import bookstore.dao.OrderItemDao;
import bookstore.model.OrderItem;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
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
		return false;
	}

	public OrderItemDao getOrderItemDao() {
		return orderItemDao;
	}

	@Resource
	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}

}
