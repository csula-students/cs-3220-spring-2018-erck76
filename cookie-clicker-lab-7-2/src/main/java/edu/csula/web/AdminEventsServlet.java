package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.storage.servlet.EventsDAOImpl;
import edu.csula.storage.servlet.UsersDAOImpl;
import edu.csula.storage.EventsDAO;
import edu.csula.storage.UsersDAO;
import edu.csula.models.Event;

@WebServlet("/admin/events")
public class AdminEventsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		EventsDAO dao = new EventsDAOImpl(getServletContext());
		Collection<Event> events = dao.getAll();
		
		System.out.println(events);
		UsersDAO userDao = new UsersDAOImpl(request.getSession());
		
		if (userDao.getAuthenticatedUser().isPresent())
		{
			EventsDAOImpl dao = new EventsDAOImpl(new Database());
			Collection<Event> events = dao.getAll();
			
			request.setAttribute("events", events);
			request.getRequestDispatcher("../WEB-INF/admin-events.jsp")
			  .forward(request, response);
		}
			else
			{
				response.sendRedirect("auth");
			}
		
		/*request.setAttribute("events", events);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin-events.jsp");
		dispatcher.forward(request, response);*/
		
		/*out.print("<!DOCTYPE html>");
		out.print("<html lang=\"en\">");
		out.print("<head>");
		out.print("	<meta charset=\"UTF-8\">");
		out.print("	<title>Incremental-Game</title>");
		out.print("</head>");
		out.print("<header><h1><p></p>Incremental Game Framework</p></h1></header>");
		out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"app.css\">");
		
		out.print("<body>");
		out.print("		<nav>");
		out.print("			<a href=\"action\">Game Information</a> |");
		out.print("			<a href=\"action\">Generators</a> |");
		out.print("			<a href=\"action\">Events</a>");
		out.print("		</nav>");
		
		out.println("<form method=\"POST\">");
		out.println("	<label for=\"eventname\">Event Name</label><br>");
		out.println("	<input type=\"text\" name=\"name\" id=\"eventname\"><br>");
		
		out.println("	<label for=\"eventDescription\">Event Description</label><br>");
		out.println("	<textarea name=\"description\" id=\"eventDescription\"></textarea><br>");
		
		out.println("	<label for=\"triggerAt\">Trigger at</label><br>");
		out.println("	<input type=\"number\" name=\"triggerAt\" id=\"triggerAt\"><br>");
		
		out.println("	<button>{Add|Edit}</button>");
		out.println("</form>");
		
		out.print(" 	<table id=\"tab\" align=\"center\" border=\"1\">");
		out.print("			<tr>");
		out.print("				<th>Name</th>");
		out.print("				<th>Description</th> ");
		out.print("				<th>TriggerAt</th>");
		out.print("			</tr>");
		
		for (Event event : events) {
			out.println("<tr>");
			out.println("	<td>" + event.getName() + "</td>");
			out.println("	<td>" + event.getDescription() + "</td>");
			out.println("	<td>" + event.getTriggerAt() + "</td>");
			out.println("<td>");
			
			out.println("	<a href=\"EditEventServlet?id=" + event.getId() +"\">Edit</a>");
			out.println("||");
			out.println("	<a href=\"DeleteEventServlet?id=" + event.getId() + "\">Delete</a>");
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.print("</body>");
		out.print("</html>");
		}
		else
		{
			response.sendRedirect("auth");
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		EventsDAO dao = new EventsDAOImpl(getServletContext());
		Collection<Event> events = dao.getAll();

		String name = request.getParameter("name");
		String description = request.getParameter("description");   
		int triggerAt = Integer.parseInt(request.getParameter("triggerAt"));
		
		Event event = new Event(events.size(), name, description, triggerAt);

		dao.add(event);
		
		response.sendRedirect("events");
	}

}
