package com.kaankilic.spring.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDb")
public class TestDB extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String user = "root";
		String pass = "";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hibizz?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			out.println("Veritabanina baglanti : " + jdbcUrl );
			
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			out.println("Basarili!!");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
		
	}

}
