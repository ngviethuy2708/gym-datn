package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelDetailBill;
import model.ModelTraining;

/**
 * Servlet implementation class ControllerAdminIndexTraining
 */

public class ControllerAdminIndexDetailBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminIndexDetailBill() {
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
		int bid = 0;
		if(request.getParameter("bid")!= null){
			bid = Integer.parseInt(request.getParameter("bid"));
		}
		
		ModelDetailBill mDetail = new ModelDetailBill();
		request.setAttribute("alDetail", mDetail.getList(bid));
		RequestDispatcher rd = request.getRequestDispatcher("/admin/indexDetail.jsp");
		rd.forward(request, response);
	}

}
