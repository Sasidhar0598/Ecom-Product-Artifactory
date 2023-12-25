package com.jdbc.web.web1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;



import com.jdbc.web.db.DbConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class SearchByID
 */
@WebServlet("/search-product")
public class SearchByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByID() {
        super();
        
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.sendRedirect("search-by-id.jsp");
		
		
       /* PrintWriter out = response.getWriter();
		
		String productId = request.getParameter("product_id");
		DbConnection db = null;
		
		try {
			// step 1: create connection
			db = new DbConnection();
			db.init();
			
			// step 2: create statement and execute query 
			String query = "SELECT * from eproducts where product_id="+productId;
			ResultSet rst = db.executeQuery(query);
			
			request.getRequestDispatcher("index.jsp").include(request, response);
			
			out.print("<div style='text-align:center;border:2px solid green; padding:20px;'>");
			while (rst.next()) {
				out.print("<div style='text-align:center;border:2px solid black; padding:5px; margin: auto 10%'>");
				out.print("<p>" + rst.getInt("product_id") + "  ,  "+ rst.getString("product_name") + 
						"  ,  " + rst.getString("product_desc") +"  ,  "+rst.getString("price"));
				out.print("</div>");
			}
			out.print("</div>");
		} catch (Exception e) {
			 e.printStackTrace();
			out.println("<h2> Exception Occured </h2>");
		} finally {
			out.close();
			db.close();
		}*/
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		//response.sendRedirect("search-product");
	PrintWriter out = response.getWriter();
		
		String productId = request.getParameter("product_id");
		DbConnection db = null;
		
		try {
			// step 1: create connection
			db = new DbConnection();
			db.init();
			
			// step 2: create statement and execute query 
			String query = "SELECT * from eproducts where product_id="+productId;
			ResultSet rst = db.executeQuery(query);
			
			request.getRequestDispatcher("index.jsp").include(request, response);
			
			out.print("<div style='text-align:center;border:2px solid green; padding:20px;'>");
			while (rst.next()) {
				out.print("<div style='text-align:center;border:2px solid black; padding:5px; margin: auto 10%'>");
				out.print("<p>" + rst.getInt("product_id") + "  ,  "+ rst.getString("product_name") + 
						"  ,  " + rst.getString("product_desc") +"  ,  "+rst.getString("price"));
				out.print("</div>");
			}
			out.print("</div>");
		} catch (Exception e) {
			 e.printStackTrace();
			out.println("<h2> Exception Occured </h2>");
		} finally {
			out.close();
			db.close();
		}
	}
}


