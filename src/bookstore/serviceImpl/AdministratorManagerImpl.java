package bookstore.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import bookstore.dao.AdministratorDao;
import bookstore.model.Administrator;
import bookstore.service.AdministratorManager;
@Component("adminManager")
public class AdministratorManagerImpl implements AdministratorManager {
	private AdministratorDao adminDao;

	@Override
	public void add(Administrator admin) throws Exception {
		adminDao.save(admin);	
	}
	@Override
	public boolean login(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.adminAuthentication(username, password);
	}

	public AdministratorDao getAdminDao() {
		return adminDao;
	}
	@Resource
	public void setAdminDao(AdministratorDao adminDao) {
		this.adminDao = adminDao;
	}
	@Override
	public Administrator getByUserName(Administrator admin) {
		return adminDao.getByUserName(admin.getUsername());
	}
	

}
