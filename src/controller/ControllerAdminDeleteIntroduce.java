package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelIntroduce;

/**
 * Servlet implementation class ControllerAdminDeleteIntroduce
 */

public class ControllerAdminDeleteIntroduce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminDeleteIntroduce() {
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
		ModelIntroduce mIntro = new ModelIntroduce();
		int iid = 0;
		String pictureOld = "";
		if(request.getParameter("iid") != null){
			iid = Integer.parseInt(request.getParameter("iid"));
		}
		pictureOld = mIntro.getPicture(iid);
		if(!pictureOld.isEmpty()){
			String filePathOld = request.getServletContext().getRealPath("") + File.separator + "files" + File.separator
					+ pictureOld;
			System.out.println(filePathOld);
			File fileOld = new File(filePathOld);
			fileOld.delete();
		}
		if(mIntro.delItem(iid)>0){
			response.sendRedirect(request.getContextPath()+"/admin/indexIntroduce");
		}
	}

}
