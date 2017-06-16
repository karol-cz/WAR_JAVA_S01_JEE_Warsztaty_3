package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MySqlSolutionDao;
import model.dao.SolutionDao;
import model.entity.Solution;
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
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
