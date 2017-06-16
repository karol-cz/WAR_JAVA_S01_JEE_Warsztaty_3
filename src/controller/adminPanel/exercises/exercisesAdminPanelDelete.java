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
 * Servlet implementation class groupsAdminPanelDelete
 */          
@WebServlet("/exercisesAdminPanelDelete")
public class exercisesAdminPanelDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ExerciseDao exerciseDao = new MySqlExerciseDao(Utils.DB_URL, Utils.USER, Utils.PASSWORD);
		int exerciseId = Integer.parseInt(request.getParameter("id"));
		exerciseDao.delete(exerciseId);
		
		getServletContext().getRequestDispatcher("/exercisesAdminPanel").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
