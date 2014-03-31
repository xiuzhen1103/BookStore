package bookstore.action;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import bookstore.model.Book;
import bookstore.model.Category;
import bookstore.model.Topic;
import bookstore.service.BookManager;
import bookstore.service.CategoryManager;
import bookstore.service.TopicManager;

import com.opensymphony.xwork2.ActionSupport;
@Component("book")
@Scope("prototype")
public class BookAction extends ActionSupport implements java.io.Serializable{
	
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
		this.listTopics = topicManager.getTopics();
		return listTopics;
	}
	public void setListTopics(List<Topic> listTopics) {
		this.listTopics = listTopics;
	}
	
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
			//listBooks  =  new ArrayList<Book>();
		        book = bookManager.get(book.getBookId());
		        listBooks.add(book);
		}
		return "addToCart";
	}
	
	public String listShoppingCart() throws Exception {
		listBooks = (List<Book>) ServletActionContext.getRequest().getSession().getAttribute("bookList");
		return "listShoppingCart";
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

}
