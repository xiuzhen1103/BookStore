package bookstore.daoImpl;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
import java.util.List;
import javax.annotation.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
<<<<<<< HEAD
=======
=======

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
import bookstore.dao.OrderItemDao;
import bookstore.model.OrderItem;

@Component("orderItemDao")
public class OrderItemDaoImpl implements OrderItemDao {

	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void save(OrderItem orderItem) throws DataAccessException {
		this.hibernateTemplate.save(orderItem);
	}

	@Override
	public boolean deleteOrderItem(Integer orderItemId)
			throws DataAccessException {
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
		// TODO Auto-generated method stub
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
		return false;
	}

	@Override
	public boolean updateOrderItem(OrderItem orderItem)
			throws DataAccessException {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
		return false;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<OrderItem> getOrderItemByOrderId(Integer orderId) throws DataAccessException {
		return (List<OrderItem>)this.hibernateTemplate.find("from OrderItem o where o.order.orderId= '" + orderId + "'");
<<<<<<< HEAD
=======
=======
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OrderItem> getOrderItem(OrderItem orderItem)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> getOrderItem() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
