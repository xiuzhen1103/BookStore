package bookstore.model;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Topic {
	private Integer topicId;
	private String name;
	private Set<BookTopic> bookTopics = new HashSet<BookTopic>(0);
	
	@Id
	@GeneratedValue
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "topic")
	@JoinColumn(name = "topicId")
	public Set<BookTopic> getBookTopics() {
		return bookTopics;
	}
	public void setBookTopics(Set<BookTopic> bookTopics) {
		this.bookTopics = bookTopics;
	}
	
}
