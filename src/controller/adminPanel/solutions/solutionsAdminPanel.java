package controller.adminPanel.solutions;

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
 * Servlet implementation class groupsAdminPanel
 */
@WebServlet("/solutionsAdminPanel")
public class solutionsAdminPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SolutionDao solutionDao = new MySqlSolutionDao(Utils.DB_URL, Utils.USER, Utils.PASSWORD);
		ArrayList<Solution> solutions = (ArrayList<Solution>) solutionDao.loadAll();
		request.setAttribute("solutions", solutions);
		
		getServletContext().getRequestDispatcher("/solutionsAdminPanel.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
