/**
 * 
 */
package bookstore.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import bookstore.dao.OrderDao;
import bookstore.model.Customer;
import bookstore.model.Orders;

/**
 * @author jack
 *
 */
@Component("orderDao")
public class OrderDaoImpl implements OrderDao {
	
	private HibernateTemplate hibernateTemplate;

	/* (non-Javadoc)
	 * @see bookstore.dao.OrderDao#deleteOrder(java.lang.Integer)
	 */
	@Override
	public boolean deleteOrder(Integer orderId) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see bookstore.dao.OrderDao#updateOrder(bookstore.model.Orders)
	 */
	@Override
	public boolean updateOrder(Orders order) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see bookstore.dao.OrderDao#getOrders(bookstore.model.Orders)
	 */
	@Override
	public List<Orders> getOrders(Orders order) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see bookstore.dao.OrderDao#getOrders()
	 */
	@Override
	public List<Orders> getOrders() throws DataAccessException {
		 Customer customer = (Customer) ServletActionContext.getRequest().getSession().getAttribute("customer");
		 return (List<Orders>)this.hibernateTemplate.find("from Orders where customerId='"+ customer.getCustomerId() + "' ORDER BY orderId DESC");
	}


	/* (non-Javadoc)
	 * @see bookstore.dao.OrderDao#save(bookstore.model.Order)
	 */
	@Override
	public void save(Orders order) throws DataAccessException {
		this.hibernateTemplate.save(order);
	}

	/**
	 * @return the hibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * @param hibernateTemplate the hibernateTemplate to set
	 */
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
