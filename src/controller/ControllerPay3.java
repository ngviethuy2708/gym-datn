package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ModelPayments;
import bean.Bill;
import bean.Payments;
import bean.Product;

/**
 * Servlet implementation class ControllerPay3
 */

public class ControllerPay3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerPay3() {
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
		ModelPayments mPayments = new ModelPayments();
		HttpSession ss = request.getSession();
		ArrayList<Product> alPro = (ArrayList<Product>)ss.getAttribute("alCart");
		Bill objBill = (Bill)ss.getAttribute("objBill");
		Payments objPayments=  mPayments.getItem(objBill.getIdPayment());
		request.setAttribute("objPayment", objPayments);
		request.setAttribute("alPro", alPro);
		RequestDispatcher rd = request.getRequestDispatcher("/public/Pay2.jsp");
		rd.forward(request, response);
	}

}
