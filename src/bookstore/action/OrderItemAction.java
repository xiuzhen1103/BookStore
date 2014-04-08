package bookstore.action;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import bookstore.model.OrderItem;
import bookstore.service.OrderItemManager;

@Component("orderItem")
@Scope("prototype")
public class OrderItemAction {
	private OrderItemManager orderItemManager;
	private OrderItem orderItem;
	private List<OrderItem> orderItems;
	private Integer orderId;
	
	public OrderItem getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public OrderItemManager getOrderItemManager() {
		return orderItemManager;
	}
	@Resource(name="orderItemManager")
	public void setOrderItemManager(OrderItemManager orderItemManager) {
		this.orderItemManager = orderItemManager;
	}
	
	public String list() throws Exception {
		this.orderItems = orderItemManager.getOrderItemByOrderId(orderId);
		return "list";	
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String listByCustomerId() throws Exception {
		this.orderItems = orderItemManager.getOrderItemByOrderId(orderId);
		return "listByCustomerId";	
	}

	
}
