package bookstore.daoImpl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import bookstore.dao.AccountDao;
import bookstore.model.Account;
import bookstore.model.Customer;
@Component("accountDao")
public class AccountDaoImpl implements AccountDao{
	private HibernateTemplate hibernateTemplate;

	@Override
	public boolean deleteAccount(final Integer accountId) throws DataAccessException {
		List<Account> accounts = hibernateTemplate.find("from Account a where a.accountId = '" + accountId + "'");

		if(accounts != null && accounts.size() > 0) {
			hibernateTemplate.executeWithNativeSession(
					new HibernateCallback() {
						@Override
						public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
							return session.createQuery
							("delete Account a where a.accountId='"+ accountId + "'").executeUpdate();
						}					
					});
			return true;
		}
		return false;
	}

	@Override
	public List<Account> getAccounts(Account account)
			throws DataAccessException {
		 return (List<Account>)this.hibernateTemplate.find("from Account");
	}

	@Override
	public Account getByAccountId(Integer accountId) throws DataAccessException {
		return (Account) this.hibernateTemplate.load(Account.class, accountId);
	}

	@Override
	public void save(Account account) throws DataAccessException {
		this.hibernateTemplate.save(account);
		
	}

	@Override
	public boolean updateAccount(Integer accountId,
			String shippingAddress, String paymentMethod, Double balance)
	throws DataAccessException {
//		Account account= (Account) this.hibernateTemplate.load(Account.class,accountId);
//		if(account!=null) {
//			account.setShippingAddress(shippingAddress);
//			account.setPaymentMethod(paymentMethod);
//			account.setBalance(balance);
//			return true;
//		}
		Account acc = new Account();
		acc.setAccountId(accountId);
		acc.setBalance(balance);
		acc.setShippingAddress(shippingAddress);
		acc.setPaymentMethod(paymentMethod);
		this.hibernateTemplate.update(acc);
		return true;
	}
	
	public List<Account> getAccountbyCustomerId(Account account) throws DataAccessException {
		Customer customer = (Customer) ServletActionContext.getRequest().getSession().getAttribute("customer");
		Integer id = customer.getCustomerId();
		StringBuffer hql = new StringBuffer();
		hql.append( " from Account ");
		hql.append(" where customerId =  "+  id);
		List<Account>  list = null;
		try{
			list = 	(List<Account>)this.hibernateTemplate.find(hql.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean updateAccount(Account account) throws DataAccessException {
		this.hibernateTemplate.update(account);
		return true;
	}

}
