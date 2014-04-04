package bookstore.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Book implements java.io.Serializable{
<<<<<<< HEAD
	
=======
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * 
	 */
>>>>>>> 82bb03b2ad8310ecfe595292aa7459bad4a4b15f
	private static final long serialVersionUID = 1L;
	private Integer bookId;
	private String title;
	private String author;
	private Double price;
	private Integer quantity;
	private Category category;
	private String imagePath;
	private Integer radioList;
	private Integer[] checkBoxes;
	private Set<BookTopic> bookTopics = new HashSet<BookTopic>(0);
	
	@Id
	@GeneratedValue
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Transient
	public Integer getRadioList() {
		return radioList;
	}
	public void setRadioList(Integer radioList) {
		this.radioList = radioList;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "book")
	@JoinColumn(name = "bookId")
	public Set<BookTopic> getBookTopics() {
		return bookTopics;
	}
	
	public void setBookTopics(Set<BookTopic> bookTopics) {
		this.bookTopics = bookTopics;
	}
	@Transient
	public Integer[] getCheckBoxes() {
		return checkBoxes;
	}
	public void setCheckBoxes(Integer[] checkBoxes) {
		this.checkBoxes = checkBoxes;
	}
	
	
}
