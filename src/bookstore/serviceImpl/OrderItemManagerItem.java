package bookstore.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import bookstore.dao.OrderItemDao;
import bookstore.model.OrderItem;
import bookstore.model.Orders;
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
		return false;
	}

	@Override
	public boolean delete(OrderItem orderItem) throws Exception {
		return false;
	}

	public OrderItemDao getOrderItemDao() {
		return orderItemDao;
	}

	@Resource
	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}



	@Override
	public List<OrderItem> getOrderItemByOrderId(Integer orderId)
			throws Exception {
		return orderItemDao.getOrderItemByOrderId(orderId);
	}

}
