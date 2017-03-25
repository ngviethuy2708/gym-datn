package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Register;
import library.LibraryConstant;
import library.LibraryPer;
import library.TimeConvert;
import model.ModelIntroduce;
import model.ModelProduct;
import model.ModelRegister;
import model.ModelUser;

/**
 * Servlet implementation class ControllerAdminIndexUsers
 */

public class ControllerIndexProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerIndexProduct() {
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
		int tongSoDong = mPro.getSum();
		int soTrang = (int)Math.ceil((float)tongSoDong/LibraryConstant.ROW_COUNT);
		int currentPage = 1;
		if(request.getParameter("page") != null){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("page", currentPage);
		request.setAttribute("soTrang", soTrang);
		int offset = (currentPage-1) * LibraryConstant.ROW_COUNT;
		request.setAttribute("alPro", mPro.getListForPaginator(offset,LibraryConstant.ROW_COUNT));
		RequestDispatcher rd = request.getRequestDispatcher("public/indexProduct.jsp");
		rd.forward(request, response);
	}

}
