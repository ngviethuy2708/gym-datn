package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelExcercises;
import model.ModelIntroduce;
import model.ModelNews;

/**
 * Servlet implementation class ControllerAdminDeleteIntroduce
 */

public class ControllerAdminDeleteExcercises extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminDeleteExcercises() {
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
		ModelExcercises  mEx  = new ModelExcercises();
		int eid = 0;
		String pictureOld = "";
		if(request.getParameter("eid") != null){
			eid = Integer.parseInt(request.getParameter("eid"));
		}
		pictureOld = mEx.getPicture(eid);
		if(!pictureOld.isEmpty()){
			String filePathOld = request.getServletContext().getRealPath("") + File.separator + "files" + File.separator
					+ pictureOld;
			System.out.println(filePathOld);
			File fileOld = new File(filePathOld);
			fileOld.delete();
		}
		if(mEx.delItem(eid)>0){
			response.sendRedirect(request.getContextPath()+"/admin/indexExcercises");
		}
	}

}
