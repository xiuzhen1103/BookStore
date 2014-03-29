package bookstore.filter;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import bookstore.model.Administrator;
import bookstore.model.Book;
import bookstore.model.Customer;


public class AuthenticationFilter extends OncePerRequestFilter {

	private static final String loginUserCode = "login.userCode"; 
	private static final Log log = LogFactory.getLog(AuthenticationFilter.class);
	private String notFilterList;
	private String[] notFilters;

	public void setNotFilterList(String notFilterList) {
		this.notFilterList = notFilterList;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException {
		try {
			//String url = request.getServletPath();
			HttpSession session = request.getSession();
			Customer customer = (Customer) session.getAttribute("customer");
			String customer_username = customer==null?null:customer.getUsername();
		
			Administrator admin = (Administrator) session.getAttribute("admin");
			String admin_username = admin==null?null:admin.getUsername();

			
			//check if user login		
			if(customer_username == null || customer_username.trim().length() ==0) {
				promptTimout("reLogin", request, response);
				return;
			}
			else if (admin_username == null || admin_username.trim().length() == 0) {
					promptTimout("reLogin", request, response);
					return;
			}

			else{
				filterChain.doFilter(request, response);
			}
		}
		catch (ServletException e) {
			throw e;
		}
		catch (Exception e) {
			log.error("Internal error", e);
			prompt("Internal error", request, response);
			return;
		}
	}


	@Override
	protected void initFilterBean() throws ServletException {
		if (notFilterList != null) {
			notFilters = notFilterList.split(" *, *");
		}
	}


	@Override
	protected boolean shouldNotFilter(HttpServletRequest request)
			throws ServletException {
		String url = request.getServletPath();

		if (notFilters != null) {
			for (int i = notFilters.length - 1; i >= 0; i--) {
				if (url.lastIndexOf(notFilters[i]) >= 0) {
					return true;
				}
			}
		}
		return false;
	}


	private void prompt(String msg, HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/noright.jsp");

		if (dispatcher != null) {
			request.setAttribute("msg", msg);

			try {
				dispatcher.forward(request, response);
			}
			catch (Exception e) {
				throw new ServletException(e);
			}
		}
	}


	private void promptTimout(String msg, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		StringBuilder rediretPage = new StringBuilder();
//		String queryString = request.getQueryString();

		rediretPage.append(request.getContextPath());
		rediretPage.append("/sessionError.jsp");
//		rediretPage.append("/minilogin.jsp?lastPage=");
//		rediretPage.append(request.getServletPath());
//
//		if (queryString != null) {
//			rediretPage.append("?");
//			rediretPage.append(URLEncoder.encode(queryString, request
//					.getCharacterEncoding()));
//		}

		try {
			response.sendRedirect(rediretPage.toString());
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
}