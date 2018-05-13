package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import edu.csula.storage.GeneratorsDAO;
import edu.csula.storage.mysql.Database;
import edu.csula.models.Generator;
import edu.csula.storage.EventsDAO;
import edu.csula.models.Event;

import edu.csula.storage.mysql.EventsDAOImpl;
import edu.csula.storage.mysql.GeneratorsDAOImpl;

import edu.csula.models.State;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
    response.setContentType("text/html");
    
		PrintWriter out = response.getWriter();

		EventsDAO dao = new EventsDAOImpl(new Database());
		Collection<Event> events = dao.getAll();
    
		GeneratorsDAO DAO = new GeneratorsDAOImpl(new Database());
		Collection<Generator> generators = DAO.getAll();

		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String state = gson.toJson(new State(events, generators));
		

		out.println(state);
		
		request.setAttribute("genIndex", generators.size() - 1);
		request.setAttribute("state", state);
    
		request.getRequestDispatcher("/WEB-INF/game.jsp").forward(request, response);
	}

}
