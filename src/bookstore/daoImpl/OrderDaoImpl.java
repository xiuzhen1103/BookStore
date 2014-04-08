<<<<<<< HEAD

package bookstore.daoImpl;
=======
<<<<<<< HEAD

package bookstore.daoImpl;
=======
/**
 * 
 */
package bookstore.daoImpl;

>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
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
<<<<<<< HEAD
=======
/**
 * @author jack
 *
 */
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
@Component("orderDao")
public class OrderDaoImpl implements OrderDao {
	
	private HibernateTemplate hibernateTemplate;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
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
<<<<<<< HEAD
=======
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
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
		 Customer customer = (Customer) ServletActionContext.getRequest().getSession().getAttribute("customer");
		 return (List<Orders>)this.hibernateTemplate.find("from Orders where customerId='"+ customer.getCustomerId() + "' ORDER BY orderId DESC");
	}

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

	/* (non-Javadoc)
	 * @see bookstore.dao.OrderDao#save(bookstore.model.Order)
	 */
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
	@Override
	public void save(Orders order) throws DataAccessException {
		this.hibernateTemplate.save(order);
	}

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
	/**
	 * @return the hibernateTemplate
	 */
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
	/**
	 * @param hibernateTemplate the hibernateTemplate to set
	 */
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
<<<<<<< HEAD



=======
<<<<<<< HEAD



=======
>>>>>>> bd8b744e89ec63d0d890b31e4b32b2c4b87f99c9
>>>>>>> 19e1717f808993f07ab01d073a149f8eda9d531a
	
}
