package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;

/**
 * Servlet implementation class ControllerEditCart
 */

public class ControllerEditCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerEditCart() {
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
		HttpSession ss = request.getSession();
		ArrayList<Product> alID = new ArrayList<>();
		ArrayList<Product> alCartEdit = (ArrayList)ss.getAttribute("alCart");
		if(request.getParameter("submit")!=null){
			if(request.getParameterValues("maSanPham[]")!=null){
				String index[] = request.getParameterValues("maSanPham[]");
				for(int i=index.length - 1;i >= 0; i--){
					int indexPro = Integer.parseInt(index[i]);		
					alCartEdit.remove(indexPro);
				}
			}
		for (Product product : alCartEdit) {
			if(request.getParameter("soLuong["+product.getIdProduct()+"]") != null){
				int number = Integer.parseInt(request.getParameter("soLuong["+product.getIdProduct()+"]"));
				product.setNumber(number);
				product.setPriceBuy(number*product.getPriceProduct());
			}
		}
		
		ss.setAttribute("alCart", alCartEdit);
		response.sendRedirect(request.getContextPath() + "/indexCart");
		}
	}

}
