package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ExerciseDao;
import model.dao.MySqlExerciseDao;
import model.dao.MySqlSolutionDao;
import model.dao.MySqlUserDao;
import model.dao.SolutionDao;
import model.dao.UserDao;
import model.entity.Exercise;
import model.entity.Solution;
import model.entity.User;
import model.utils.Utils;

/**
 * Servlet implementation class servlet1
 */
@WebServlet("/welcome")
public class welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SolutionDao solutionDao = new MySqlSolutionDao(Utils.DB_URL, Utils.USER, Utils.PASSWORD);
		int numberOfRows = Integer.parseInt(getServletContext().getInitParameter("numberOfRows"));
		
		ArrayList<Solution> list = (ArrayList<Solution>) solutionDao.loadAll(numberOfRows);
		request.setAttribute("list", list);
		request.setAttribute("numberOfRows", numberOfRows);
		
		ExerciseDao exerciseDao = new MySqlExerciseDao(Utils.DB_URL, Utils.USER, Utils.PASSWORD);
		ArrayList<Exercise> exercises = (ArrayList<Exercise>) exerciseDao.loadAll();
		request.setAttribute("exercises", exercises);
		
		UserDao userDao = new MySqlUserDao(Utils.DB_URL, Utils.PASSWORD, Utils.USER);
		ArrayList<User> users = (ArrayList<User>) userDao.findAll();
		request.setAttribute("users", users);
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
