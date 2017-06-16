package controller.adminPanel.users;

import java.io.IOException;

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
 * Servlet implementation class usersAdminPanelAddNewSubmit
 */
@WebServlet("/usersAdminPanelAddNewSubmit")
public class usersAdminPanelAddNewSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = new MySqlUserDao(Utils.DB_URL, Utils.PASSWORD, Utils.USER);
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setSurname(request.getParameter("surname"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setPerson_group_id(Integer.parseInt(request.getParameter("person_group_id")));

		userDao.insert(user);
		getServletContext().getRequestDispatcher("/usersAdminPanel").forward(request, response);

		doGet(request, response);
	}

}
