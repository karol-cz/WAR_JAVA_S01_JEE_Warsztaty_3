package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MySqlSolutionDao;
import model.dao.MySqlUserDao;
import model.dao.SolutionDao;
import model.dao.UserDao;
import model.entity.Solution;
import model.entity.User;
import model.utils.Utils;

/**
 * Servlet implementation class usersShort
 */
@WebServlet("/usersShort")
public class usersShort extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao userDao = new MySqlUserDao(Utils.DB_URL, Utils.PASSWORD, Utils.USER);

		int groupId = Integer.parseInt(request.getParameter("groupId"));
		ArrayList<User> users = (ArrayList<User>) userDao.loadAllByGrupId(groupId);
		
		request.setAttribute("users", users);
		request.setAttribute("groupId", groupId);
		
		getServletContext().getRequestDispatcher("/usersShort.jsp").forward(request, response);
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
