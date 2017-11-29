package it.objectmethod.world.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.world.model.City;
import it.objectmethod.world.model.Country;

public class CountryDao {
	
	
	public List<String> getAllDistinctContinents(){
		Connection conn = null;
		Statement stmt = null;
		List<String> continentList  = new ArrayList<String>();
		
		try{
			
			conn = ConnectionFactory.getConnection();
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT distinct continent FROM country";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				String continent = rs.getString("continent");
				 continentList.add(continent);
			}
			
			rs.close();
			stmt.close();
			conn.close();		
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
				se2.printStackTrace();
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				
				se.printStackTrace();
			}
		}
		return continentList;
	}
	
	public List<Country> getCountriesByContinent(String continent){
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Country> countries  = new ArrayList<Country>();
		
		try{	
			conn = ConnectionFactory.getConnection();
			System.out.println("Creating statement...");
			
			String sql = "SELECT Code, Name FROM country WHERE Continent = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, continent);
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				Country c = new Country();
				c.setCode(rs.getString("Code"));
				c.setName(rs.getString("Name"));
				countries.add(c);
			}

			
			rs.close();
			stmt.close();
			conn.close();		
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
				se2.printStackTrace();
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				
				se.printStackTrace();
			}
		}
		return countries;
	}
	
	public List<City> getCitiesByCountry(String countryCode){
		Connection conn = null;
		PreparedStatement stmt = null;
		List<City> cities  = new ArrayList<City>();
		
		try{
			conn = ConnectionFactory.getConnection();
			System.out.println("Creating statement...");
			
			String sql = "SELECT Population, Name FROM city WHERE CountryCode = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, countryCode);
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				City c = new City();
				c.setPopulation(rs.getString("Population"));
				c.setName(rs.getString("Name"));
				cities.add(c);
			}

			rs.close();
			stmt.close();
			conn.close();		
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
				se2.printStackTrace();
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				
				se.printStackTrace();
			}
		}
		return cities;
	}
}
