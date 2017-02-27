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
import model.ModelBill;
import model.ModelUsers;
import bean.SearchUserForDate;
import bean.SearchUsers;

/**
 * Servlet implementation class ControllerAdminSearchUsers
 */

public class ControllerAdminSearchBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminSearchBill() {
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
		ModelBill mBill = new ModelBill();
		TimeConvert cv = new TimeConvert();
		String type = "";
		String something = "";
		if(request.getParameter("submit") != null){
			type = request.getParameter("optradio");
			something = request.getParameter("something");	
		}
		if(cv.isDate(something) == false){
			String something2 = new String(something.getBytes("ISO-8859-1"), "UTF-8");
			SearchUsers item = new SearchUsers(type, something2);
			request.setAttribute("alBill",mBill.getListForSearch(item) );
		}else{
			Date dateUntil = cv.getDateTime(something);
			java.sql.Date dateSQl = cv.getSqlDate(dateUntil);
			SearchUserForDate item2 = new SearchUserForDate(type, dateSQl);
			request.setAttribute("alBill", mBill.getListForSearchDate(item2));	
		}
		RequestDispatcher rd = request.getRequestDispatcher("/admin/searchBill.jsp");
		rd.forward(request, response);
		
	}

}
