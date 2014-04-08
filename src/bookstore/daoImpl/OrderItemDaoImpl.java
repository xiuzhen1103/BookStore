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
		return false;
	}

	@Override
	public boolean updateOrderItem(OrderItem orderItem)
			throws DataAccessException {
		return false;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<OrderItem> getOrderItemByOrderId(Integer orderId) throws DataAccessException {
		return (List<OrderItem>)this.hibernateTemplate.find("from OrderItem o where o.order.orderId= '" + orderId + "'");
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
