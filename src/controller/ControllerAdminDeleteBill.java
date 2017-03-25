package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.ModelBill;
import model.ModelUser;

/**
 * Servlet implementation class ControllerAdminDeleteUsers
 */

public class ControllerAdminDeleteBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminDeleteBill() {
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
		int bid = Integer.parseInt(request.getParameter("bid"));
		System.out.println(bid);
		if(mBill.delItem(bid) > 0 && mBill.delDetailBill(bid) > 0){
			response.sendRedirect(request.getContextPath()+"/admin/indexBill");
		}
	}

}
