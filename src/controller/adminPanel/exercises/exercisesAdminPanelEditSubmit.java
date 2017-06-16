package controller.adminPanel.exercises;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ExerciseDao;
import model.dao.GroupDao;
import model.dao.MySqlExerciseDao;
import model.dao.MySqlGroupDao;
import model.utils.Utils;

/**
 * Servlet implementation class groupsAdminPanelSubmit
 */
@WebServlet("/exercisesAdminPanelEditSubmit")
public class exercisesAdminPanelEditSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ExerciseDao exerciseDao = new MySqlExerciseDao(Utils.DB_URL, Utils.USER, Utils.PASSWORD);
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		exerciseDao.update(id, title, description);
		
		getServletContext().getRequestDispatcher("/exercisesAdminPanel").forward(request, response);
		doGet(request, response);
	}

}
