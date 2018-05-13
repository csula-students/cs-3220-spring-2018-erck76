package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.models.Event;
import edu.csula.storage.EventsDAO;
import edu.csula.storage.servlet.EventsDAOImpl;

/**
 * Servlet implementation class EditEventServlet
 */
@WebServlet("/EditEventServlet")
public class EditEventServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		EventsDAO dao = new EventsDAOImpl(getServletContext());
		int id = Integer.parseInt(request.getParameter("id"));
		Event eve = null;
		
		for (Event x : dao.getAll())
		{
			if (id == x.getId())
			{
				eve = x;
			}
		}
		
		 request.getRequestDispatcher("/WEB-INF/admin-edit-events.jsp").forward(request, response);
		
		/*out.print("<html lang=\"en\">");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Incremental game framework - game information Edit</title>");
		out.print("<link rel=\"stylesheet\" href=\"../app.css");
		out.print("</head>");
		
		out.print("<header>");
		out.print("		<h1>Incremental game framework</h1>");
		out.print("</header>");
		
		out.print("");
		out.print("<body>");
		
		
		out.print("<form method='POST'>");
		out.print("		<h2>Edit</h2>");
		out.print("		<label for='name'>Name: </label>");
		out.print("		<input type='text'name='name' id='eventname' value='"+ eve.getName() + "' />");
		
		out.print("		<label for='eventdes'>Event Descrption</label><br>");
		out.print("		<textarea name='description' id='eventdes'>" + eve.getDescription() + "</textarea>");
		
		out.print("		<label for='triggerAt'>Trigger At</label><br>");
		out.print("		<input type='number' name='triggerAt' id='trigAt' value='"+ eve.getTriggerAt() + "' /><br>");
		
		out.print("		<button>Submit</button>");
		out.print("</form>");
		
		out.print("</body>");*/
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//EventsDAO dao = new EventsDAOImpl(getServletContext());
		 EventsDAOImpl dao = new EventsDAOImpl(new Database());
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("eventname");
		String description = request.getParameter("eventdes");
		int triggerAt = Integer.parseInt(request.getParameter("trigAt"));
		
		Event event = new Event(id, name, description, triggerAt);
		
		dao.set(id, event);

		response.sendRedirect("events");//for some reason crashes here. Do not know where to redirect!!

	}

}
