package controller.adminPanel.exercises;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class groupsAdminPanel
 */
@WebServlet("/exercisesAdminPanel")
public class exercisesAdminPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ExerciseDao exerciseDao = new MySqlExerciseDao(Utils.DB_URL, Utils.USER, Utils.PASSWORD);
		ArrayList<Exercise> exercises = (ArrayList<Exercise>) exerciseDao.loadAll();
		request.setAttribute("exercises", exercises);
		
		getServletContext().getRequestDispatcher("/exercisesAdminPanel.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
