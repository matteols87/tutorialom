package it.objectmethod.world.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.world.dao.CountryDao;
import it.objectmethod.world.model.Country;

public class CountriesServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String continent = req.getParameter("continent");
		System.out.println("Ricevuto parametro continent: "+continent);
		
		CountryDao dao = new CountryDao();
		List<Country> countries = dao.getCountriesByContinent(continent);
		
		req.setAttribute("nazioni", countries);
		req.getRequestDispatcher("jsp/countries.jsp").forward(req, resp);
	}

}
