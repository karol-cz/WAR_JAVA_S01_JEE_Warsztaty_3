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
import model.entity.Solution;
import model.utils.Utils;

/**
 * Servlet implementation class groupsAdminPanelAddNewSubmit
 */
@WebServlet("/solutionsAdminPanelAddNewSubmit")
public class solutionsAdminPanelAddNewSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SolutionDao solutionDao = new MySqlSolutionDao(Utils.DB_URL, Utils.USER, Utils.PASSWORD);
		Solution solution = new Solution();
		
		LocalDate created = Utils.stringToLocalDate(request.getParameter("created"));
		LocalDate updated = Utils.stringToLocalDate(request.getParameter("updated"));
		solution.setCreated(created);
		solution.setUpdated(updated);
		solution.setDescription(request.getParameter("description"));
		solution.setExercise_id(Integer.parseInt(request.getParameter("exercise_id")));
		solution.setUsers_id(Integer.parseInt(request.getParameter("users_id")));
		
		solutionDao.saveToDB(solution);
		
		getServletContext().getRequestDispatcher("/solutionsAdminPanel").forward(request, response);
		
		doGet(request, response);
	}

}
