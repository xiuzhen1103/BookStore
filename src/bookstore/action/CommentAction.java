package bookstore.action;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import bookstore.model.Comment;
import bookstore.model.Customer;
import bookstore.service.CommentManager;

import com.opensymphony.xwork2.ActionSupport;

@Component("comment")
@Scope("prototype")
public class CommentAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Comment comment = new Comment();
	private List<Comment> comments;
	private CommentManager commentManager;
	private String message = "";
	private Integer bookId =1;
	private String x ="1"; 

	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public CommentManager getCommentManager() {
		return commentManager;
	}
	@Resource(name="commentManager")
	public void setCommentManager(CommentManager commentManager) {
		this.commentManager = commentManager;
	}
	
	public String get() throws Exception{
		this.comment = commentManager.get(comment);
		return "get";
	}
	
	public String execute() throws Exception{
		comment.setCustomer(getCustomerFromSession());
		commentManager.add(this.comment);
		return "success";
	}
	
	public String delete() throws Exception{
		boolean deleted = commentManager.delete(comment);
		if(deleted) {
			message="delete succeeded";
			return "success";
		}
		else {
			message = "delete failed, Employer id is not exist";
			return "fail";
		}
	}
	public String add() throws Exception {
		//HttpServletRequest request = ServletActionContext.getRequest();
		//request.setAttribute("bookId", bookId);
		this.comments = commentManager.getByBookId(bookId);
		return "input";
	}
	public String list() throws Exception {
		//HttpServletRequest request = ServletActionContext.getRequest();
		//request.setAttribute("bookId", bookId);
		this.comments = commentManager.getByBookId(bookId);
		return "list";
	}
	
	public String update() throws Exception {
		boolean updated = commentManager.updatet(comment);
		if(updated) {
			message = "update succeeded";
			return "success";
		}
		else {
			message = "update failed";
			return "fail";
		}
	}
	
	 private Customer getCustomerFromSession() {
	        return (Customer) ServletActionContext.getRequest().getSession().getAttribute("customer");
	    }
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}

	

}
