package controller.adminPanel.solutions;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MySqlSolutionDao;
import model.dao.SolutionDao;
import model.utils.Utils;

/**
 * Servlet implementation class groupsAdminPanelSubmit
 */
@WebServlet("/solutionsAdminPanelEditSubmit")
public class solutionsAdminPanelEditSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SolutionDao solutionDao = new MySqlSolutionDao(Utils.DB_URL, Utils.USER, Utils.PASSWORD);
		
		int id = Integer.parseInt(request.getParameter("id"));		
		LocalDate created = Utils.stringToLocalDate(request.getParameter("created"));
		LocalDate updated = Utils.stringToLocalDate(request.getParameter("updated"));
		String description = request.getParameter("description");
		int exercise_id = Integer.parseInt(request.getParameter("exercise_id"));
		int users_id = Integer.parseInt(request.getParameter("users_id"));
		
		solutionDao.update(id, created, updated, description, exercise_id, users_id);
		
		
		getServletContext().getRequestDispatcher("/solutionsAdminPanel").forward(request, response);
		doGet(request, response);
	}

}
