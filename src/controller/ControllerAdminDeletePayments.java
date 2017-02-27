package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import model.ModelPayments;
import model.ModelTraining;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerAdminDeleteUsers
 */

public class ControllerAdminDeletePayments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminDeletePayments() {
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
		int payid = Integer.parseInt(request.getParameter("payid"));
		if(mPay.delItem(payid) > 0){
			response.sendRedirect(request.getContextPath()+"/admin/indexPayments");
		}
	}

}
