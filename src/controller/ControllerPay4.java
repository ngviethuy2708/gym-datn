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

import model.ModelBill;
import model.ModelDetailBill;
import model.ModelPayments;
import bean.Bill;
import bean.DetailBill;
import bean.Payments;
import bean.Product;

/**
 * Servlet implementation class ControllerPay3
 */

public class ControllerPay4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerPay4() {
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
		ModelDetailBill mDetail = new ModelDetailBill();
		HttpSession ss = request.getSession();
		Bill objBill = (Bill)ss.getAttribute("objBill");
		String msg = "";
		if(request.getParameter("submit")!=null){
			int result = mBill.addItem(objBill);
			if(result > 0 ){
				int idbill = mBill.getIdMax();
				ArrayList<DetailBill> alDetail = new ArrayList<>();
				ArrayList<Product> alpro = (ArrayList<Product>)ss.getAttribute("alCart");
				for(Product p:alpro){
					DetailBill objDetailBill = new DetailBill(0, idbill, p.getIdProduct(), p.getNumber());
					alDetail.add(objDetailBill);
				}
				int result2 = mDetail.adDetailBill(alDetail);
			}
			if(objBill.getIdPayment() == 5 || objBill.getIdPayment() == 2){
				msg +=  "Xin chúc mừng! Đơn hàng của bạn đã được đặt thành công!" 
						+"Chúng tôi sẽ liên lạc trong thời gian sớm nhất!";
			}
			ss.removeAttribute("alCart");
			ss.removeAttribute("objBill");
			request.setAttribute("msg1", msg);
			RequestDispatcher rd = request.getRequestDispatcher("/public/Pay3.jsp");
			rd.forward(request, response);
		}
	}

}
