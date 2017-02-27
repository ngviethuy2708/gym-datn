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
import model.ModelRegister;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerAdminIndexUsers
 */

public class ControllerAdminIndexUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminIndexUsers() {
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
		if(!LibraryPer.isLogin(request, response)){
			return;
		}
		ModelUsers mUsers = new ModelUsers();
		ModelRegister mRegis = new ModelRegister();
		TimeConvert cv = new TimeConvert();
		String dateStr = cv.getDateNow();
		Date dateUtil = cv.getDateTime(dateStr);
		ArrayList<Register> alRegis = mRegis.getUsersInRegister();
		for (Register objRegis : alRegis) {
			java.sql.Date dateSql = objRegis.getEndDate();
			Date objDate = cv.getNormalDate(dateSql);
			if(objDate.before(dateUtil)){
				mUsers.editItemForEnddate(objRegis.getIdUsers());
			}
		}
		int tongSoDong = mUsers.getSum();
		int soTrang = (int)Math.ceil((float)tongSoDong/LibraryConstant.ROW_COUNT);
		int currentPage = 1;
		if(request.getParameter("page") != null){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("page", currentPage);
		request.setAttribute("soTrang", soTrang);
		int offset = (currentPage-1) * LibraryConstant.ROW_COUNT;
		request.setAttribute("alUsers", mUsers.getListForPaginator(offset,LibraryConstant.ROW_COUNT));
		RequestDispatcher rd = request.getRequestDispatcher("/admin/indexUsers.jsp");
		rd.forward(request, response);
	}

}
