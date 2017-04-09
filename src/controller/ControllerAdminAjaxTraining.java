package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelTraining;

/**
 * Servlet implementation class ControllerAdminAjaxRegister
 */

public class ControllerAdminAjaxTraining extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAjaxTraining() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelTraining mTraining = new ModelTraining();
		PrintWriter out = response.getWriter();
		int id = Integer.valueOf(request.getParameter("aid"));
		int active = Integer.valueOf(request.getParameter("aactive"));
		String imgActive = "";
		String result = "";
		if(mTraining.setActive(id,active) > 0){
			if(active == 1){
				imgActive = request.getContextPath() + "/templates/admin/images/icon-fail.png";
				active = 0;
			}else{
				imgActive = request.getContextPath() + "/templates/admin/images/icon-success.png";
				active = 1;
			}
			result += "<a href='avascript:void(0)' onclick='return setActive("+id +","+ active +")' title=''><img style='width:30px; height:30px;'' src='" + imgActive + "'></a>";
			out.print(result);
		}
	}

}
