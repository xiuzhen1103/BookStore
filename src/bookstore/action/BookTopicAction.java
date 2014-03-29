package bookstore.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import bookstore.model.BookTopic;
import bookstore.service.BookTopicManager;

import com.opensymphony.xwork2.ActionSupport;

@Component("bookTopic")
@Scope("prototype")
public class BookTopicAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private BookTopic bookTopic;
	private BookTopicManager bookTopicManager;
	private String message ="";
	private List<BookTopic> bookTopics;

	public BookTopicManager getBookTopicManager() {
		return bookTopicManager;
	}
	@Resource(name="bookTopicManager")
	public void setBookTopicManager(BookTopicManager bookTopicManager) {
		this.bookTopicManager = bookTopicManager;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public BookTopic getBookTopic() {
		return bookTopic;
	}
	public void setBookTopic(BookTopic bookTopic) {
		this.bookTopic = bookTopic;
	}
	
	public String execute() throws Exception{
		bookTopicManager.add(this.bookTopic);
		return "success";
	}
	
	public String list() throws Exception {
		this.bookTopics = bookTopicManager.getTopicBooks(this.bookTopic);
		return "list";	
	}
	public List<BookTopic> getBookTopics() {
		return bookTopics;
	}
	public void setBookTopics(List<BookTopic> bookTopics) {
		this.bookTopics = bookTopics;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String delete() throws Exception{
		boolean	deleted = bookTopicManager.delete(bookTopic);
		if(deleted) {
			message = "delete succeeded";
			return "success";
		}
		else {
			message = "delete failed, category id is not exist";
			return "fail";
		}
	}
	
	
	

}
