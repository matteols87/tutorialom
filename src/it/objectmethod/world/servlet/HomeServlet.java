package it.objectmethod.world.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.world.dao.CountryDao;

public class HomeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CountryDao dao = new CountryDao();
		List<String> contList = dao.getAllDistinctContinents();
		
		req.setAttribute("continents", contList);
		req.getRequestDispatcher("jsp/home.jsp").forward(req, resp);
	}
	
	

}
