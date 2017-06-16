package controller.adminPanel.groups;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.GroupDao;
import model.dao.MySqlGroupDao;
import model.entity.Group;
import model.utils.Utils;

/**
 * Servlet implementation class groupsAdminPanel
 */
@WebServlet("/groupsAdminPanel")
public class groupsAdminPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GroupDao groupDao = new MySqlGroupDao(Utils.DB_URL, Utils.USER, Utils.PASSWORD);
		ArrayList<Group> groups = (ArrayList<Group>) groupDao.loadAll();
		request.setAttribute("groups", groups);
		
		getServletContext().getRequestDispatcher("/groupsAdminPanel.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
