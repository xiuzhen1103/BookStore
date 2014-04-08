package bookstore.action;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import bookstore.model.Account;
import bookstore.model.Book;
import bookstore.model.Category;
import bookstore.model.Customer;
import bookstore.model.OrderItem;
import bookstore.model.Orders;
import bookstore.model.RequestBook;
import bookstore.model.Topic;
import bookstore.service.AccountManager;
import bookstore.service.BookManager;
import bookstore.service.CategoryManager;
import bookstore.service.OrderItemManager;
import bookstore.service.OrderManager;
import bookstore.service.TopicManager;

import com.opensymphony.xwork2.ActionSupport;
@Component("book")
@Scope("prototype")
public class BookAction extends ActionSupport{
	private static final long serialVersionUID = -2350807061495695406L;
	private Book book = new Book();
	private BookManager bookManager;
	private List<Book> books;
	private CategoryManager cateManager;
	private List<Category> listCategory;
	private List<Topic> listTopics;
	private TopicManager topicManager;
	private String message="";
	private List<Book> listBooks;
	private Topic topic;
	private AccountManager accountManager;
	private OrderManager orderManager;
	private OrderItemManager orderItemManager;
	private String sort;
	private List<Book> listBookSortByParam;
	private static int flag =0;
	private List<RequestBook> requestBooks;
	
	public BookManager getBookManager() {
		return bookManager;
	}
	@Resource(name="bookManager")
	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public String list() throws Exception {
		this.books = bookManager.getBooks(this.book);
		return "list";	
	}
	
	public String logged() throws Exception {
		this.books = bookManager.getBooks(this.book);
		return "logged";	
	}
	
	public String booklist() throws Exception {
		this.books = bookManager.getBooks(this.book);
		return "booklist";	
	}
	
	public CategoryManager getCateManager() {
		return cateManager;
	}
	@Resource(name="categoryManager")
	public void setCateManager(CategoryManager cateManager) {
		this.cateManager = cateManager;
	}
	
	public String addBook() throws Exception {
		this.listTopics = topicManager.getTopics();
		this.listCategory = cateManager.getCategorys();
		return "addBook";	
	}
	public List<Category> getListCategory() {
		return listCategory;
	}
	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}
	
	public String execute() throws Exception{
		bookManager.add(this.book);
		return "success";
	}
	public String books() throws Exception{
		bookManager.add(this.book);
		return "books";
	}
	
	public String book() throws Exception{
		bookManager.add(this.book);
		return "success";
	}
	
	public String delete() throws Exception{
		boolean deleted = bookManager.delete(book.getBookId());
		if(deleted) {
			message="delete succeeded";
			return "success";
		}
		else {
			message = "delete failed, Employer id is not exist";
			return "fail";
		}
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public TopicManager getTopicManager() {
		return topicManager;
	}
	@Resource(name="topicManager")
	public void setTopicManager(TopicManager topicManager) {
		this.topicManager = topicManager;
	}
	public List<Topic> getListTopics() throws Exception {
		return listTopics;
	}
	public void setListTopics(List<Topic> listTopics) {
		this.listTopics = listTopics;
	}
	
	@SuppressWarnings("unchecked")
	public String addToCart() throws Exception {
		  HttpSession session=ServletActionContext.getRequest().getSession();
		  listBooks = (List<Book>) session.getAttribute("bookList");
		if(listBooks==null){
			listBooks  =  new ArrayList<Book>();
			book =bookManager.get(book.getBookId());
		       listBooks.add(book);
		        session.setAttribute("bookList", listBooks);
		        System.out.println(listBooks.size());
		}else{
		        book = bookManager.get(book.getBookId());
		        listBooks.add(book);
		}
		return "addToCart";
	}
	
	public String pay() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		Customer cus = (Customer) session.getAttribute("customer");
		System.out.println(requestBooks);
		Orders order = new Orders();
		Double totalAmount = 0.0;
		int quantity = 0;
		for(RequestBook book : requestBooks){
			totalAmount += book.getPrice() * book.getQuantity();
			quantity += book.getQuantity();
		}
		List<Account> accList = accountManager.getAccountbyCustomerId(null);
		if(accList == null || accList.size() <= 0){
			throw new Exception("The account is not exist");
		}
		Account acc = accList.get(0);
		order.setAccount(acc);
		order.setCustomer(cus);
		order.setTotalAmount(totalAmount);
		order.setQuantity(quantity);
		orderManager.add(order);
		List<Orders> orderList = orderManager.listOrders();
		if(orderList == null || orderList.size() <= 0){
			throw new Exception("Save failed");
		}
		for(RequestBook book : requestBooks){
			OrderItem item = new OrderItem();
			item.setBook(new Book(book.getBookId()));
			item.setOrder(order);
			item.setPrice(book.getPrice());
			item.setQuantity(book.getQuantity());
			orderItemManager.add(item);
		}
		Double balance = acc.getBalance() - order.getTotalAmount();
		if(balance < 0.0){
			throw new Exception("insufficient balance");
		}
		acc.setBalance(balance); 
		accountManager.update(acc);     
		for(RequestBook book : requestBooks){
			Book b = bookManager.get(book.getBookId());
			b.setQuantity(b.getQuantity() - book.getQuantity());
			bookManager.update(b);
		}
		return "paySuccess";
	}
	
	@SuppressWarnings("unchecked")
	public String listShoppingCart() throws Exception {
		listBooks = (List<Book>) ServletActionContext.getRequest().getSession().getAttribute("bookList");
		return "listShoppingCart";
	}
	
	public String get() throws Exception{
		this.book = this.bookManager.get(book.getBookId());
		return "get";
	}
	public String update() throws Exception {
		boolean updated = bookManager.update(book);
		if(updated) {
			message = "update succeeded";
			return "success";
		}
		else {
			message = "update failed";
			return "fail";
		}
	}

	
	public String listTopics() throws Exception {
		this.listTopics = topicManager.getTopics();
		StringBuffer sb = new StringBuffer();
		for(Topic topic : listTopics) {
            sb.append(topic.getTopicId() + "_" + topic.getName()).append(","); 
		}
		if (sb.toString().endsWith(",")) {
		    sb.deleteCharAt(sb.length() - 1);
		}
		ServletActionContext.getResponse().getWriter().print(sb.toString());
		return null;
	}

	public List<RequestBook> getRequestBooks() {
		return requestBooks;
	}

	public void setRequestBooks(List<RequestBook> requestBooks) {
		this.requestBooks = requestBooks;
	}


	public AccountManager getAccountManager() {
		return accountManager;
	}

	@Resource(name="accountManager")
	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	public OrderManager getOrderManager() {
		return orderManager;
	}

	@Resource(name="orderManager")
	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}
	
	public List<Book> getListBooks() {
		return listBooks;
	}
	public void setListBooks(List<Book> listBooks) {
		this.listBooks = listBooks;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public OrderItemManager getOrderItemManager() {
		return orderItemManager;
	}
	@Resource(name="orderItemManager")
	public void setOrderItemManager(OrderItemManager orderItemManager) {
		this.orderItemManager = orderItemManager;
	}
	public String sortBook() throws Exception {
		
		if(flag%2==0) {
		this.listBookSortByParam = bookManager.sortBookByParam(sort);
		flag++;
		}
		else if(flag%2 != 0) {
			this.listBookSortByParam = bookManager.sortBookByParam2(sort);
			flag++;
		}

		return "sortBook";
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public List<Book> getListBookSortByParam() {
		return listBookSortByParam;
	}
	public void setListBookSortByParam(List<Book> listBookSortByParam) {
		this.listBookSortByParam = listBookSortByParam;
	}
	public static int getFlag() {
		return flag;
	}
	public static void setFlag(int flag) {
		BookAction.flag = flag;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
