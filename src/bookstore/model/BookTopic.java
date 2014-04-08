package bookstore.model;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class BookTopic implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1406638093998138710L;
	private Integer bookTopicId;
	private Book book;
	private Topic topic;
	private Integer[] checkboxes;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	public Integer getBookTopicId() {
		return bookTopicId;
	}
	public void setBookTopicId(Integer bookTopicId) {
		this.bookTopicId = bookTopicId;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookId", nullable = false)
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topicId", nullable = false)
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	@Transient
	public Integer[] getCheckboxes() {
		return checkboxes;
	}
	public void setCheckboxes(Integer[] checkboxes) {
		this.checkboxes = checkboxes;
	}

}
