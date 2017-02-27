package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import model.ModelIntroduce;
import model.ModelProduct;

/**
 * Servlet implementation class ControllerDetailIntroduces
 */
public class ControllerDetailProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDetailProduct() {
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
		ModelProduct mPro = new ModelProduct();
		int pid = 0;
		if(request.getParameter("pid")!= null){
			pid = Integer.parseInt(request.getParameter("pid"));
		}
		request.setAttribute("objPro", mPro.getItem(pid));	
		RequestDispatcher rd = request.getRequestDispatcher("/public/detailProduct.jsp");
		rd.forward(request, response);
		
	}

}
