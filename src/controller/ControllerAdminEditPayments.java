package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Payments;
import bean.Training;
import bean.Users;
import library.LibraryString;
import library.TimeConvert;
import model.ModelPayments;
import model.ModelTraining;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerEditUsers
 */

public class ControllerAdminEditPayments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminEditPayments() {
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
		ModelPayments mPay = new ModelPayments();
		int payid = 0;
		if(request.getParameter("payid") != null){
			payid = Integer.parseInt( request.getParameter("payid"));
		}
		if(request.getParameter("sua") != null){
			String namePayments = request.getParameter("paymentsName");
			namePayments = new String(namePayments.getBytes("ISO-8859-1"), "UTF-8");
			String detailPayments = request.getParameter("paymentsDetail");
			detailPayments = new String(detailPayments.getBytes("ISO-8859-1"), "UTF-8");
			Payments objPay = new Payments(payid, namePayments, detailPayments);
			if(mPay.editItem(objPay)>0){
				response.sendRedirect(request.getContextPath()+"/admin/indexPayments");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/editPayments?msg=edit0&payid="+payid);
			}
		}else{
			request.setAttribute("objPay", mPay.getItem(payid));
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editPayments.jsp");
			rd.forward(request, response);
		}
	}

}
