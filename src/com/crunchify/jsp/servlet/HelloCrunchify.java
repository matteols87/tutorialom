package com.crunchify.jsp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
public class HelloCrunchify extends HttpServlet {
	
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /*@Override // reading the user input
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("un", username);
        request.setAttribute("pw", password);
        
        request.getRequestDispatcher("JSP/HelloCrunchify.jsp").forward(request, response);    
        }
        */	
	// JDBC driver name and database URL
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		final String DB_URL = "jdbc:mysql://localhost/world";

		//  Database credentials
		 final String USER = "root";
		 final String PASS = "root";

		//public static void main(String[] args) {
			Connection conn = null;
			Statement stmt = null;
			List<String> continentList  = new ArrayList<String>();
			
			try{
				//STEP 2: Register JDBC driver
				Class.forName(JDBC_DRIVER);

				
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL,USER,PASS);

				System.out.println("Creating statement...");
				stmt = conn.createStatement();
				String sql;
				sql = "SELECT continent FROM country";
				ResultSet rs = stmt.executeQuery(sql);

		
				while(rs.next()){
				
					String continent = rs.getString("continent");
					 continentList.add(continent);
					

				}
				
				for (int i=0;i<continentList.size();i++){	
					for (int j=i+1;j<continentList.size();j++){
			            if(continentList.get(i).equals(continentList.get(j))){	
			            	continentList.remove(j);
			            	}			     
						}	
					}
				
				rs.close();
				stmt.close();
				conn.close();
				request.setAttribute("continentList", continentList);
					
				
			}catch(SQLException se){
				
				se.printStackTrace();
			}catch(Exception e){
				
				e.printStackTrace();
			}finally{
			//modifica
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
			
			request.getRequestDispatcher("JSP/HelloCrunchify.jsp").forward(request, response); 
		}
			
    }