package bookstore.model;

import java.awt.Image;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	private Integer bookId;
	private String title;
	private String author;
	private Double price;
	private Category category;
	private Image imagePath;
	
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
	
	public Image getImagePath() {
		return imagePath;
	}
	public void setImagePath(Image imagePath) {
		this.imagePath = imagePath;
	}
	@ManyToOne
	@JoinColumn(name = "categoryId")
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	

}
