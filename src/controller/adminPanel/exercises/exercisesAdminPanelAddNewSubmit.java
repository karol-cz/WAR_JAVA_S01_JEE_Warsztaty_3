package controller.adminPanel.exercises;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ExerciseDao;
import model.dao.MySqlExerciseDao;
import model.entity.Exercise;
import model.utils.Utils;

/**
 * Servlet implementation class groupsAdminPanelAddNewSubmit
 */
@WebServlet("/exercisesAdminPanelAddNewSubmit")
public class exercisesAdminPanelAddNewSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ExerciseDao exerciseDao = new MySqlExerciseDao(Utils.DB_URL, Utils.USER, Utils.PASSWORD);
		Exercise exercise = new Exercise();
		
		exercise.setTitle(request.getParameter("title"));
		exercise.setDescription(request.getParameter("description"));
		exerciseDao.saveToDB(exercise);
		
		getServletContext().getRequestDispatcher("/exercisesAdminPanel").forward(request, response);
		
		doGet(request, response);
	}

}
