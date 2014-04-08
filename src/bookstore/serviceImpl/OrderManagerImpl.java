/**
 * 
 */
package bookstore.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import bookstore.dao.OrderDao;
import bookstore.model.Orders;
import bookstore.service.OrderManager;

/**
 * @author jack
 *
 */
@Component("orderManager")
public class OrderManagerImpl implements OrderManager {
	
	private OrderDao orderDao;

	/* (non-Javadoc)
	 * @see bookstore.service.OrderManager#add(bookstore.model.Order)
	 */
	@Override
	public void add(Orders order) throws Exception {
		orderDao.save(order);
	}
	
	/* (non-Javadoc)
	 * @see bookstore.service.OrderManager#getOrders()
	 */
	@Override
	public List<Orders> getOrders() throws Exception {
		return orderDao.getOrders();
	}

	/* (non-Javadoc)
	 * @see bookstore.service.OrderManager#update(bookstore.model.Order)
	 */
	@Override
	public boolean update(Orders order) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see bookstore.service.OrderManager#getOrders(bookstore.model.Order)
	 */
	@Override
	public List<Orders> getOrders(Orders order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see bookstore.service.OrderManager#delete(bookstore.model.Order)
	 */
	@Override
	public boolean delete(Orders order) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the orderDao
	 */
	public OrderDao getOrderDao() {
		return orderDao;
	}

	/**
	 * @param orderDao the orderDao to set
	 */
	@Resource
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	
	

}
