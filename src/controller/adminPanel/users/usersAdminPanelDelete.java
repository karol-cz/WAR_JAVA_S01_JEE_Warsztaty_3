package controller.adminPanel.users;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MySqlUserDao;
import model.dao.UserDao;
import model.entity.User;
import model.utils.Utils;

/**
 * Servlet implementation class usersAdminPanelDelete
 */
@WebServlet("/usersAdminPanelDelete")
public class usersAdminPanelDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = new MySqlUserDao(Utils.DB_URL, Utils.PASSWORD, Utils.USER);
		int userId = Integer.parseInt(request.getParameter("id"));
		userDao.deleteById(userId);
		//ArrayList<User> users = (ArrayList<User>) userDao.findAll();
		
	//	request.setAttribute("users", users);
		
		//getServletContext().getRequestDispatcher("/usersAdminPanel.jsp").forward(request, response);
		getServletContext().getRequestDispatcher("/usersAdminPanel").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
