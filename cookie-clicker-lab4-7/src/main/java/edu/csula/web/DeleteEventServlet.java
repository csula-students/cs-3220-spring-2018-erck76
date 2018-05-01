package edu.csula.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.models.Event;
import edu.csula.storage.EventsDAO;
import edu.csula.storage.servlet.EventsDAOImpl;

/**
 * Servlet implementation class DeleteEventServlet
 */
@WebServlet("/admin/DeleteEventServlet")
public class DeleteEventServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("id"));
		EventsDAO dao = new EventsDAOImpl(getServletContext());
		
		List<Event>events = dao.getAll();
		
		for(int i = 0; i < events.size(); i++)
		{
			if (events.get(i).getId() == id)
			{
				events.remove(i);
			}
		}
		response.sendRedirect("events");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
