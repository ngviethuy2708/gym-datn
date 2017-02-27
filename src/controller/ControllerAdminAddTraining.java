package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.TimeConvert;
import model.ModelTraining;
import model.ModelUsers;
import bean.Training;
import bean.Users;

/**
 * Servlet implementation class ControllerAdminAddUsers
 */

public class ControllerAdminAddTraining extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAddTraining() {
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
		ModelTraining mTraining = new ModelTraining();
		if(request.getParameter("submit")!=null){
			String nameTraining = request.getParameter("trainingName");
			nameTraining = new String(nameTraining.getBytes("ISO-8859-1"), "UTF-8");
			int dayTraining = Integer.parseInt(request.getParameter("trainingDay"));
			int priceTraining = Integer.parseInt(request.getParameter("trainingPrice"));
			Training objTraining = new Training(0, nameTraining, dayTraining, priceTraining);
			if(mTraining.addItem(objTraining)>0){
				response.sendRedirect(request.getContextPath()+"/admin/indexTraining");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/addTraining?msg=add0");
			}
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/addTraining.jsp");
			rd.forward(request, response);
		}
		
	}

}
