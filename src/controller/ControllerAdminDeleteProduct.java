package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelIntroduce;
import model.ModelNews;
import model.ModelProduct;

/**
 * Servlet implementation class ControllerAdminDeleteIntroduce
 */

public class ControllerAdminDeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminDeleteProduct() {
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
		String pictureOld = "";
		if(request.getParameter("pid") != null){
			pid = Integer.parseInt(request.getParameter("pid"));
		}
		pictureOld = mPro.getPicture(pid);
		if(!pictureOld.isEmpty()){
			String filePathOld = request.getServletContext().getRealPath("") + File.separator + "files" + File.separator
					+ pictureOld;
			System.out.println(filePathOld);
			File fileOld = new File(filePathOld);
			fileOld.delete();
		}
		if(mPro.delItem(pid)>0){
			response.sendRedirect(request.getContextPath()+"/admin/indexProduct");
		}
	}

}
