
package bookstore.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import bookstore.dao.OrderDao;
import bookstore.model.Orders;
import bookstore.service.OrderManager;

@Component("orderManager")
public class OrderManagerImpl implements OrderManager {
	
	private OrderDao orderDao;

	@Override
	public void add(Orders order) throws Exception {
		orderDao.save(order);
	}
	

	@Override
	public List<Orders> getOrdersByCustomerId() throws Exception {
		return orderDao.listOrdersByCustomerId();
	}


	@Override
	public boolean update(Orders order) throws Exception {
		return false;
	}
	
	public List<Orders> listOrders() throws Exception {
		return orderDao.listOrders();
	}

	@Override
	public boolean delete(Orders order) throws Exception {
		return false;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	@Resource
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	
	

}
