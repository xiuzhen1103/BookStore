
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

@Component("orderDao")
public class OrderDaoImpl implements OrderDao {
	
	private HibernateTemplate hibernateTemplate;

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
		 Customer customer = (Customer) ServletActionContext.getRequest().getSession().getAttribute("customer");
		 return (List<Orders>)this.hibernateTemplate.find("from Orders where customerId='"+ customer.getCustomerId() + "' ORDER BY orderId DESC");
	}

	@Override
	public void save(Orders order) throws DataAccessException {
		this.hibernateTemplate.save(order);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}



	
}
