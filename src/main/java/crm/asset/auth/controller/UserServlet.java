package crm.asset.auth.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm.asset.auth.model.User;
import crom.asset.auth.dao.UserDao;

@WebServlet("/register")
public class UserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private UserDao userDao=new UserDao();
	
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		response.getWriter().append("Served at:").append(request.getContextPath());
		
		RequestDispatcher rd=request.getRequestDispatcher("/view/welcome.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact_no");
		
		User user=new User(first_name, last_name, username, password, address, contact);
		try {
			userDao.registerUser(user);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("/view/welcome.jsp");
		rd.forward(request, response);
	}
	
}
