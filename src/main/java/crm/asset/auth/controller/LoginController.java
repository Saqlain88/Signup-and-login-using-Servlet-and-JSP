package crm.asset.auth.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crom.asset.auth.dao.UserDao;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UserDao userDao = new UserDao();

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at:").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("/view/welcome.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("email");
		String password = request.getParameter("password");
		// User user=new User(first_name, last_name, username, password, address,
		// contact);
		try {
			if (userDao.validate(username, password)) {
				RequestDispatcher rd = request.getRequestDispatcher("/view/welcome.jsp");
				rd.forward(request, response);
			} else {
				PrintWriter out=response.getWriter();
				out.print("Incorrect username or password");
				throw new RuntimeException("Invalid username or password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
