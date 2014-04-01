package bookstore.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import bookstore.model.Administrator;
import bookstore.service.AdministratorManager;

import com.opensymphony.xwork2.ActionSupport;
@Component("admin")
@Scope("prototype")
public class AdminAction extends ActionSupport{
	private Administrator admin;
	private AdministratorManager adminManager;
	private String message = "";
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	public AdministratorManager getAdminManager() {
		return adminManager;
	}
	@Resource(name="adminManager")
	public void setAdminManager(AdministratorManager adminManager) {
		this.adminManager = adminManager;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String execute() throws Exception{
		adminManager.add(admin);
		return "success";
	}
	
	public String isLogin() throws Exception {
		boolean authenticated = adminManager.login(admin.getUsername(), admin.getPassword());
		if (authenticated) {
			message = "login succeeded ";
			ServletActionContext.getRequest().getSession().setAttribute("admin", admin);
			System.out.println("AdminId:" + admin.getAdminId());
			return "success";
		} else {
			message = "login failed ";
			return "fail";
		}
	}
	
	
	public String logout() throws Exception {
		ServletActionContext.getRequest().getSession().removeAttribute("admin");
		return "logout";
	}
	
	
	
	

}
