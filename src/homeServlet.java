

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


/**
 * Servlet implementation class homeServlet
 */
@WebServlet("/homeServlet")
public class homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String method = request.getParameter("method");
		
		
		if(method!=null){ 
					    
		
		 if(method.equals("Search"))
		 {
			 String query= request.getParameter("limitedtextarea");
			 
			 if(query.startsWith("update"))
			 {
				 try {
					DBUtility.DBUtility.runQuery(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 System.out.println("Update database successfully");
				 try {
					DBUtility.DBUtility.runQuery("Insert into selectquery (query) values ('"+query+"'); ");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 System.out.println("Insert this query into database successfully");
			 }
			 else if(query.startsWith("delete"))
			 {
				 try {
					DBUtility.DBUtility.runQuery(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 System.out.println("Delete database successfully");
				 try {
					DBUtility.DBUtility.runQuery("Insert into selectquery (query) values ('"+query+"'); ");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 System.out.println("Insert this query into database successfully");
			 }
			 else if(query.startsWith("insert"))
			 {
				 try {
					DBUtility.DBUtility.runQuery(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 System.out.println("Insert database successfully");
				 try {
					DBUtility.DBUtility.runQuery("Insert into selectquery (query) values ('"+query+"'); ");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 System.out.println("Insert this query into database successfully");
			 }
			 else if(query.startsWith("select"))
			 {
				 List<String> lists= new ArrayList<String>();
				try {
					lists = DBUtility.DBUtility.select(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	 
				 session.setAttribute("lists", lists);
				 List<String> columnnamelists =  new ArrayList<String>();
				try {
					columnnamelists = DBUtility.DBUtility.columnnamelist(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 session.setAttribute("columnnamelists", columnnamelists);
				 
				 int col = 0;
				try {
					col = DBUtility.DBUtility.columnnum(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				 session.setAttribute("colnum", col);
				 getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);;
			 }
				 
				
					
			 
		 }
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
