package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.TimeConvert;
import model.ModelIntroduce;
import model.ModelNews;
import model.ModelUsers;
import bean.SearchUserForDate;
import bean.SearchUsers;

/**
 * Servlet implementation class ControllerAdminSearchUsers
 */

public class ControllerAdminSearchNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminSearchNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelNews mNews = new ModelNews();
		String something = "";
		if(request.getParameter("submit") != null){
			something = request.getParameter("something");
		}
		String something2 = new String(something.getBytes("ISO-8859-1"), "UTF-8");
		request.setAttribute("alNews",mNews.getListForSearch(something2) );

		RequestDispatcher rd = request.getRequestDispatcher("/admin/searchNews.jsp");
		rd.forward(request, response);
		
	}

}