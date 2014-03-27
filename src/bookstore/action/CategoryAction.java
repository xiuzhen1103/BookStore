package bookstore.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import bookstore.model.Category;
import bookstore.service.CategoryManager;

import com.opensymphony.xwork2.ActionSupport;

@Component("category")
@Scope("prototype")
public class CategoryAction extends ActionSupport{
	private Category category;
	private CategoryManager categoryManager;
	private String message="";
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public CategoryManager getCategoryManager() {
		return categoryManager;
	}
	@Resource(name="categoryManager")
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception{
		categoryManager.add(category);
		return "success";
	}
	
	public String update() throws Exception {
		boolean updated = categoryManager.update(category);
		if(updated) {
			message = "update succeeded ";
			return "success";
		}
			message = "update failed";
		return "fail";
	}
	
	public String delete() throws Exception{
		boolean	deleted = categoryManager.delete(category);
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
