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

/**
 * Servlet implementation class EditGeneratorServlet
 */
@WebServlet("/EditGeneratorServlet")
public class EditGeneratorServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// TODO: render the generators page HTML
		//out.println("<h1>Hello generators servlet!</h1>");
		GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
		int id = Integer.parseInt(request.getParameter("id"));
		
		Generator generator = null;
		for (Generator a : dao.getAll())
		{
			if (id == a.getId())
			{
				generator = a;	
			}
		}
		
		//UsersDAO userDao = new UsersDAOImpl(request.getSession());
		
		
		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"en\">");
		out.print("<head>");
		out.print("	<meta charset=\"UTF-8\">");
		out.print("	<title>Edit Incremental-Game Generator</title>");
		out.print("</head>");
		out.print("<header><h1><p></p>Incremental Game Framework Gen</p></h1></header>");
		out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"app.css\">");
		
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
		
		out.println("</main>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
		Collection<Generator> generators = dao.getAll();
		
		int id = Integer.parseInt(request.getParameter("id"));
	    String name = request.getParameter("name");
		String description = request.getParameter("description");  
		int rate = Integer.parseInt(request.getParameter("rate"));
		int baseCost = Integer.parseInt(request.getParameter("cost"));
		int unlockAt = Integer.parseInt(request.getParameter("unlock"));
		
		Generator generator = new Generator(generators.size(), name, description, rate, baseCost, unlockAt);
		dao.set(id,generator);
		
		response.sendRedirect("generators");
		//doGet(request, response);
	}

}
