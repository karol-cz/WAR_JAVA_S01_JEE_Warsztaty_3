package controller.adminPanel.groups;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.GroupDao;
import model.dao.MySqlGroupDao;
import model.utils.Utils;

/**
 * Servlet implementation class groupsAdminPanelDelete
 */          
@WebServlet("/groupsAdminPanelDelete")
public class groupsAdminPanelDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GroupDao groupDao = new MySqlGroupDao(Utils.DB_URL, Utils.USER, Utils.PASSWORD);
		int groupId = Integer.parseInt(request.getParameter("id"));
		groupDao.delete(groupId);
		
		getServletContext().getRequestDispatcher("/groupsAdminPanel").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
