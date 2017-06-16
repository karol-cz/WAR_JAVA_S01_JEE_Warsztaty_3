package controller.adminPanel.exercises;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ExerciseDao;
import model.dao.MySqlExerciseDao;
import model.utils.Utils;

/**
 * Servlet implementation class groupsAdminPanelEdit
 */
@WebServlet("/exercisesAdminPanelEdit")
public class exercisesAdminPanelEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int exerciseId = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("exerciseId", exerciseId);
		getServletContext().getRequestDispatcher("/exercisesAdminPanelEdit.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
