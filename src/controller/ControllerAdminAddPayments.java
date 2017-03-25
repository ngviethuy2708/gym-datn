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
import model.ModelPayments;
import model.ModelTraining;
import model.ModelUser;
import bean.Payments;
import bean.Training;
import bean.User;

/**
 * Servlet implementation class ControllerAdminAddUsers
 */

public class ControllerAdminAddPayments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAddPayments() {
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
		ModelPayments mPay = new ModelPayments();
		if(request.getParameter("submit")!=null){
			String namePayments = request.getParameter("paymentsName");
			namePayments = new String(namePayments.getBytes("ISO-8859-1"), "UTF-8");
			String detail = request.getParameter("paymentsDetail");
			detail = new String(detail.getBytes("ISO-8859-1"), "UTF-8");
			Payments objPay = new Payments(0, namePayments, detail);
			if(mPay.addItem(objPay)>0){
				response.sendRedirect(request.getContextPath()+"/admin/indexPayments");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/addPayments?msg=add0");
			}
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/addPayments.jsp");
			rd.forward(request, response);
		}
		
	}

}
