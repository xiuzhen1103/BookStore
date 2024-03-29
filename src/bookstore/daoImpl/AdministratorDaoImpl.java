package bookstore.daoImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import bookstore.dao.AdministratorDao;
import bookstore.model.Administrator;
import bookstore.model.Customer;

@Component("adminDao")
public class AdministratorDaoImpl implements AdministratorDao{
	private HibernateTemplate hibernateTemplate; 

	@Override
	public boolean adminAuthentication(String username, String password)
	throws DataAccessException {
		List<Administrator> admins = hibernateTemplate.find("from Administrator a where a.username='"+username + "' and a.password='"+ password + "'");
		if(admins != null && admins.size() > 0) {
			return true;
		}
		return false;
	}
	@Override
	public void save(Administrator admin) throws DataAccessException {
		hibernateTemplate.save(admin);
		
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public Administrator getByUserName(String username) throws DataAccessException {
		 List<Administrator> admins =  hibernateTemplate.find("from Administrator a where a.username = '" + username + "'");
		 if(admins != null && admins.size() > 0) {
			 return admins.get(0);
			}
		return null;
	}

}
