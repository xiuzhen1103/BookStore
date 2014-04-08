package bookstore.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import bookstore.dao.CategoryDao;
import bookstore.model.Category;
import bookstore.service.CategoryManager;

@Component("categoryManager")
public class CategoryManagerImpl implements CategoryManager{
	private CategoryDao categoryDao;

	@Override
	public void add(Category category) throws Exception {
		categoryDao.save(category);
	}

	@Override
	public boolean delete(Category category) throws Exception {
		return categoryDao.deleteCategory(category.getCategoryId());
	}

	@Override
	public boolean update(Category category) throws Exception {
		return categoryDao.updateCategory(category.getCategoryId(), category.getCategoryName());
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	@Resource
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Category> getCategorys() throws Exception {
		return categoryDao.getCategorys();
	}

	@Override
	public Category getbyId(Category category) throws Exception {
		return categoryDao.getById(category.getCategoryId());
	}
	
	

}
