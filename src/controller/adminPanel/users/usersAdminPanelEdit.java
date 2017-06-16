package controller.adminPanel.users;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.GroupDao;
import model.dao.MySqlGroupDao;
import model.dao.MySqlUserDao;
import model.dao.UserDao;
import model.entity.Group;
import model.utils.Utils;

/**
 * Servlet implementation class usersAdminPanelEdit
 */
@WebServlet("/usersAdminPanelEdit")
public class usersAdminPanelEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("userId", userId);
		
		
		GroupDao groupDao = new MySqlGroupDao(Utils.DB_URL, Utils.USER, Utils.PASSWORD);
		ArrayList<Group> groups = (ArrayList<Group>) groupDao.loadAll();
		
		request.setAttribute("groups", groups);
		
		getServletContext().getRequestDispatcher("/usersAdminPanelEdit.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		UserDao userDao = new MySqlUserDao(Utils.DB_URL, Utils.PASSWORD, Utils.USER);
//		int userId = Integer.parseInt(request.getParameter("id"));
//		String name = request.getParameter("name");
//		String surname = request.getParameter("surname");
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		int person_group_id = Integer.parseInt(request.getParameter("person_group_id"));
//		
//		userDao.update(userId, name, surname, email, password, person_group_id);
//		
//		getServletContext().getRequestDispatcher("/usersAdminPanelEdit").forward(request, response);
		
		
		doGet(request, response);
	}

}
