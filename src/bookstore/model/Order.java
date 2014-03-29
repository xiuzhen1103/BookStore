package bookstore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Order {
	private Integer orderId;
	private Account accountId;
	private Book bookId;
	private Double price;
	private Integer quantity;
	private Date createTime;
	
	@Id
	@GeneratedValue
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public Account getAccountId() {
		return accountId;
	}
	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}
	public Book getBookId() {
		return bookId;
	}
	public void setBookId(Book bookId) {
		this.bookId = bookId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
