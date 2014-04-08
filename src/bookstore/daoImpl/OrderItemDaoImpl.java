package bookstore.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOrderItem(OrderItem orderItem)
			throws DataAccessException {
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
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
