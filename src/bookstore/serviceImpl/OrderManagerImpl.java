<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
/**
 * 
 */
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
package bookstore.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import bookstore.dao.OrderDao;
import bookstore.model.Orders;
import bookstore.service.OrderManager;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
/**
 * @author jack
 *
 */
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
@Component("orderManager")
public class OrderManagerImpl implements OrderManager {
	
	private OrderDao orderDao;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
	/* (non-Javadoc)
	 * @see bookstore.service.OrderManager#add(bookstore.model.Order)
	 */
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
	@Override
	public void add(Orders order) throws Exception {
		orderDao.save(order);
	}
	
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a

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

<<<<<<< HEAD
=======
=======
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
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
	public OrderDao getOrderDao() {
		return orderDao;
	}

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
	/**
	 * @param orderDao the orderDao to set
	 */
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
	@Resource
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	
	

}
