package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Bill;
import bean.User;
import library.TimeConvert;

/**
 * Servlet implementation class ControllerPay2
 */

public class ControllerPay2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerPay2() {
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
		TimeConvert cv = new TimeConvert();
		HttpSession ss = request.getSession();
		User objU = (User)ss.getAttribute("objUser");
		if(request.getParameter("submit")!=null){
			int id = Integer.parseInt(request.getParameter("thanhtoan"));
			String thongtinthem = request.getParameter("thongtinthem");
			String dateStr = cv.getDateNow();
			Date dateNow = cv.getDateTime(dateStr);
			java.sql.Date dateSql =  cv.getSqlDate(dateNow);
			Bill objBill = new Bill(0, objU.getIdUser(), id, thongtinthem,  dateSql, false, false);
			ss.setAttribute("objBill", objBill);
			response.sendRedirect(request.getContextPath() + "/pay3");
		}
	}

}
