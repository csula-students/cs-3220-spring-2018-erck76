package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.models.Generator;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.storage.UsersDAO;
import edu.csula.storage.servlet.GeneratorsDAOImpl;
import edu.csula.storage.servlet.UsersDAOImpl;

@WebServlet("/admin/generators")
public class AdminGeneratorsServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// TODO: render the generators page HTML
		//out.println("<h1>Hello generators servlet!</h1>");
		GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
		Collection<Generator> generators = dao.getAll();
		System.out.println(generators);
		UsersDAO userDao = new UsersDAOImpl(request.getSession());
		
		if (userDao.getAuthenticatedUser().isPresent())
		{
		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"en\">");
		out.print("<head>");
		out.print("	<meta charset=\"UTF-8\">");
		out.print("	<title>Incremental-Game Generator</title>");
		out.print("</head>");
		out.print("<header><h1><p></p>Incremental Game Framework Gen</p></h1></header>");
		out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"app.css\">");
		
		out.print("<body>");
		out.print("		<nav>");
		out.print("			<a href=\"action\">Game Information</a> |");
		out.print("			<a href=\"action\">Generators</a> |");
		out.print("			<a href=\"action\">Events</a>");
		out.print("		</nav>");
		
		
		out.println("<main>");
		out.println("<form method= \"POST\">");
		out.println("	<label for=\"name\">Generator Name</label>");
		out.println("	<input type=\"text\" id=\"name\" name = \"name\">");
		
		out.println("	<label for=\"description\">Generator Description</label>");
		out.println("	<textarea id=\"description\" name = \"description\"></textarea>");
		
		
		out.println("	<label for=\"rate\">Generator rate</label>");
		out.println("	<input type=\"number\" id=\"rate\" name = \"rate\">");
		
		out.println("	<label for=\"cost\">Base cost</label>");
		out.println("	<input type=\"number\" id=\"cost\" name = \"cost\">");
		
		out.println("	<label for=\"unlock_at\">Unlock At</label>");
		out.println("	<input type=\"number\" id=\"unlock_at\" name = \"unlock\">");
		
		out.println("	<button>Save</button>");
		out.println("</form>");
		
		out.print(" 	<table id=\"tab\" align=\"center\" border=\"1\">");
		out.println("<thead>");
		out.println("	<tr>");
		out.println("		<th>Name</th>");
		out.println("		<th>Description</th>");
		out.println("		<th>Rate</th>");
		out.println("		<th>Cost</th>");
		out.println("		<th>Unlock</th>");
		out.println("		<th>Action</th>");
		out.println("	</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		
		for (Generator generator : generators)
		{
			out.println("<tr>");
			out.println("	<td>"+ generator.getName()+"</td>");
			out.println("	<td>"+ generator.getDescription()+"</td>");
			out.println("	<td>"+ generator.getRate()+"</td>");
			out.println("	<td>"+ generator.getBaseCost()+"</td>");
			out.println("	<td>"+ generator.getUnlockAt()+"</td>");
			
			out.println("<td>");
			out.println("<a href=\"EditGeneratorServlet?id=" + generator.getId() +"\">Edit</a>");
				out.println("|");
				out.println("<a href=\"DeleteGeneratorServlet?id=" + generator.getId() + "\">Delete</a>");
			out.println("</tr>");
		}
		
		out.println("</tbody>");
		out.println("</table>");
		out.println("</main>");
		out.println("</body>");
		out.println("</html>");
		
		}
		else
		{
			response.sendRedirect("auth");
		}
		
	}


	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle upsert transaction
		GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
		Collection<Generator> generators = dao.getAll();

		
		String name = request.getParameter("name");
		String description = request.getParameter("description");  
		int rate = Integer.parseInt(request.getParameter("rate"));
		int baseCost = Integer.parseInt(request.getParameter("cost"));
		int unlockAt = Integer.parseInt(request.getParameter("unlock"));
		
		Generator generator = new Generator(generators.size(), name, description, rate, baseCost, unlockAt);
		dao.add(generator);
		response.sendRedirect("generators");
	}
}
