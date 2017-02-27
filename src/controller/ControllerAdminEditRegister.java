package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Register;
import bean.Users;
import library.LibraryString;
import library.TimeConvert;
import model.ModelRegister;
import model.ModelTraining;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerEditUsers
 */

public class ControllerAdminEditRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminEditRegister() {
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
		ModelRegister mRegister = new ModelRegister();
		ModelTraining mTraining = new ModelTraining();
		TimeConvert cv = new TimeConvert();
		String dateStr = cv.getDateNow();
		Date dateNow = cv.getDateTime(dateStr);
		int rid = 0;
		if(request.getParameter("rid") != null){
			rid = Integer.parseInt( request.getParameter("rid"));
		}
	
		if(request.getParameter("sua") != null){
			int idTraining = Integer.valueOf(request.getParameter("combobox"));
			System.out.println(idTraining);
			String dateStr1 = request.getParameter("beginDate");
			Date dateUtil1 = cv.getDateTime(dateStr1);
			java.sql.Date beginDate = cv.getSqlDate(dateUtil1);
			
			String dateStr2 = request.getParameter("endDate");
			Date dateUtil2 = cv.getDateTime(dateStr2);
			java.sql.Date endDate = cv.getSqlDate(dateUtil2);
			int iduser = Integer.parseInt(request.getParameter("idUsers"));
			boolean result = dateUtil2.after(dateNow);
			if(dateUtil2.after(dateNow) ){
				mRegister.editTypeUsersWhenAdminUpdateEnddate(iduser);
			}
			
			Register  objRegister = new Register(rid, idTraining, beginDate, endDate);
			if(mRegister.editItem(objRegister)>0){
				response.sendRedirect(request.getContextPath()+"/admin/indexRegister");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/editRegister?rid="+rid);
			}
		}else{
			request.setAttribute("alTraining", mTraining.getList());
			request.setAttribute("objRegis", mRegister.getItem(rid));
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editRegister.jsp");
			rd.forward(request, response);
		}
	}

}
