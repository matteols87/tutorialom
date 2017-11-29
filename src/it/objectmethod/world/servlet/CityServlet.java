package it.objectmethod.world.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.world.dao.CountryDao;
import it.objectmethod.world.model.City;
import it.objectmethod.world.model.Country;

public class CityServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String countryCode = req.getParameter("code");
		System.out.println(countryCode);
		
		
		CountryDao dao = new CountryDao();
		List<City> cities = dao.getCitiesByCountry(countryCode);

		req.setAttribute("cities", cities);
		req.getRequestDispatcher("jsp/cities.jsp").forward(req, resp);
	}

}
