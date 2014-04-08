<<<<<<< HEAD

package bookstore.daoImpl;
=======
/**
 * 
 */
package bookstore.daoImpl;

>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import bookstore.dao.OrderDao;
import bookstore.model.Customer;
import bookstore.model.Orders;

<<<<<<< HEAD
=======
/**
 * @author jack
 *
 */
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
@Component("orderDao")
public class OrderDaoImpl implements OrderDao {
	
	private HibernateTemplate hibernateTemplate;

<<<<<<< HEAD
	@Override
	public boolean deleteOrder(Integer orderId) throws DataAccessException {
		return false;
	}


	@Override
	public boolean updateOrder(Orders order) throws DataAccessException {
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> listOrders() throws DataAccessException {
		return (List<Orders>)this.hibernateTemplate.find("from Orders");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> listOrdersByCustomerId() throws DataAccessException {
=======
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
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
		 Customer customer = (Customer) ServletActionContext.getRequest().getSession().getAttribute("customer");
		 return (List<Orders>)this.hibernateTemplate.find("from Orders where customerId='"+ customer.getCustomerId() + "' ORDER BY orderId DESC");
	}

<<<<<<< HEAD
=======

	/* (non-Javadoc)
	 * @see bookstore.dao.OrderDao#save(bookstore.model.Order)
	 */
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
	@Override
	public void save(Orders order) throws DataAccessException {
		this.hibernateTemplate.save(order);
	}

<<<<<<< HEAD
=======
	/**
	 * @return the hibernateTemplate
	 */
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

<<<<<<< HEAD
=======
	/**
	 * @param hibernateTemplate the hibernateTemplate to set
	 */
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
<<<<<<< HEAD



=======
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
	
}
