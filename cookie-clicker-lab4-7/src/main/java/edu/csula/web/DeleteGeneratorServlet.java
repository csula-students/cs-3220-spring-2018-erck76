package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Collection;

import edu.csula.storage.servlet.GeneratorsDAOImpl;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.models.Generator;
import edu.csula.storage.servlet.UsersDAOImpl;
import edu.csula.storage.UsersDAO;
import edu.csula.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/admin/DeleteGeneratorServlet")
public class DeleteGeneratorServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int id = Integer.parseInt(request.getParameter("id"));
	  
	  GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
	  
	  List <Generator> generators = (List<Generator>) dao.getAll();
	((List<Generator>) dao).remove(id);
	
	response.sendRedirect("generators");

  
   }
}