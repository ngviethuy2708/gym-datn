package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelProduct;
import bean.Product;
import bean.SparQlTest;

/**
 * Servlet implementation class ControllerSearchProduct
 */

public class ControllerSearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerSearchProduct() {
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
		SparQlTest sparql = new SparQlTest();
		ModelProduct mPro = new ModelProduct();
		ArrayList<Product> alProSparQl = null;
		ArrayList<Product> alProSQL = null;
		if(request.getParameter("submit") != null){
			String proCategories = request.getParameter("proCategories");
			String madeIn = request.getParameter("madeIn");
			alProSparQl = sparql.searchProduct(proCategories, madeIn);
			for (Product product : alProSparQl) {
				System.out.println(product.getNameProduct());
			}
			alProSQL = mPro.getListForSparQl(alProSparQl);
			for (Product product : alProSQL) {
				System.out.println(product.getIdProduct());
			}
		}
		request.setAttribute("alPro", alProSQL);
		RequestDispatcher rd = request.getRequestDispatcher("/public/searchProduct.jsp");
		rd.forward(request, response);
		
	}

}
