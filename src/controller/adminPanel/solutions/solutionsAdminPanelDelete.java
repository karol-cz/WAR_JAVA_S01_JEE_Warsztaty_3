package controller.adminPanel.solutions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MySqlSolutionDao;
import model.dao.SolutionDao;
import model.utils.Utils;

/**
 * Servlet implementation class groupsAdminPanelDelete
 */          
@WebServlet("/solutionsAdminPanelDelete")
public class solutionsAdminPanelDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SolutionDao solutionDao = new MySqlSolutionDao(Utils.DB_URL, Utils.USER, Utils.PASSWORD);
		int solutionId = Integer.parseInt(request.getParameter("id"));
		solutionDao.delete(solutionId);
		
		getServletContext().getRequestDispatcher("/solutionsAdminPanel").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
