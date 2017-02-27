package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Training;
import bean.Users;
import library.LibraryString;
import library.TimeConvert;
import model.ModelTraining;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerEditUsers
 */

public class ControllerAdminEditTraining extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminEditTraining() {
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
		ModelTraining mTraining = new ModelTraining();
		int tid = 0;
		if(request.getParameter("tid") != null){
			tid = Integer.parseInt( request.getParameter("tid"));
		}
		if(request.getParameter("sua") != null){
			String nameTraining = request.getParameter("trainingName");
			nameTraining = new String(nameTraining.getBytes("ISO-8859-1"), "UTF-8");
			int dayTraining = Integer.parseInt(request.getParameter("trainingDay"));
			int priceTraining = Integer.parseInt(request.getParameter("trainingPrice"));
			Training objTraining = new Training(tid, nameTraining, dayTraining, priceTraining);
			if(mTraining.editItem(objTraining)>0){
				response.sendRedirect(request.getContextPath()+"/admin/indexTraining");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/editTraining?msg=edit0&tid="+tid);
			}
		}else{
			request.setAttribute("objTraining", mTraining.getItem(tid));
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editTraining.jsp");
			rd.forward(request, response);
		}
	}

}
