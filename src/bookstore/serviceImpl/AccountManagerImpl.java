package bookstore.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import bookstore.dao.AccountDao;
import bookstore.model.Account;
import bookstore.service.AccountManager;

@Component("accountManager")
public class AccountManagerImpl implements AccountManager{
	private AccountDao accountDao;

	@Override
	public boolean delete(Account account) throws Exception {
		return accountDao.deleteAccount(account.getAccountId());
	}

	@Override
	public List<Account> getAccountbyCustomerId(Account account)
			throws Exception {
		return accountDao.getAccountbyCustomerId(account);
	}

	@Override
	public List<Account> getAccounts(Account account) throws Exception {
		return accountDao.getAccountbyCustomerId(account);
	}

	@Override
	public Account getByAccountId(Account account) throws Exception {
		return accountDao.getByAccountId(account.getAccountId());
	}

	@Override
	public void add(Account account) throws Exception {
		accountDao.save(account);
		
	}

	@Override
	public boolean update(Account account) throws Exception {
		// TODO Auto-generated method stub
		return accountDao.updateAccount(account.getAccountId(), account.getShippingAddress(), account.getPaymentMethod(), account.getBalance());
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}
	@Resource
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

}
