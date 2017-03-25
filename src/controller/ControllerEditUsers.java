package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import library.LibraryString;
import library.TimeConvert;
import model.ModelUser;

/**
 * Servlet implementation class ControllerEditUsers
 */

public class ControllerEditUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerEditUsers() {
        super();
        
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
		ModelUser mUser = new ModelUser();
		TimeConvert cv = new TimeConvert();
		if(request.getParameter("submit") != null){
			int uid = Integer.parseInt( request.getParameter("uid"));
			String userName = request.getParameter("userName");
			String passWord = request.getParameter("passWord");
			String fullName = request.getParameter("fullName");
			fullName = new String(fullName.getBytes("ISO-8859-1"), "UTF-8");
			String date1 = request.getParameter("birthDay");
			Date  date2 = cv.getDateTime(date1);
			java.sql.Date date3 = cv.getSqlDate(date2);
			String addDress = request.getParameter("address");
			addDress = new String(addDress.getBytes("ISO-8859-1"), "UTF-8");
			String phoneNumber = request.getParameter("phoneNumber");
			User objUser = new User(uid, userName, passWord, fullName, date3, addDress, phoneNumber);
			if(mUser.editItem(objUser)>0){
				response.sendRedirect(request.getContextPath()+"/indexUser");
			}
		}
	}

}
