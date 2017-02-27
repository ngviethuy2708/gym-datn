package controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import bean.Register;
import bean.Training;
import bean.Users;
import library.LibraryPer;
import library.LibraryPerPuclic;
import library.TimeConvert;
import model.ModelRegister;
import model.ModelTraining;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerIndex
 */

public class ControllerRegisterTrainning extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerRegisterTrainning() {
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
		ModelTraining mTrainning = new ModelTraining();
		ModelRegister mRegister = new ModelRegister();
		ModelUsers mUser = new ModelUsers();
		int checkUser = 0;
		HttpSession ss = request.getSession();
		Users objUser = (Users)ss.getAttribute("objUser");
		if(objUser == null){
			response.sendRedirect(request.getContextPath()+"/index?training=training0");
			return;
		}
		if(objUser.isRegister()==true){
			checkUser = 1;
			request.setAttribute("objRegis", mRegister.getUserInRegister(objUser.getIdUser()));
		}else if(objUser.isRegister()==false){
			if(request.getParameter("submit")!=null){
				int idUsers = objUser.getIdUser();
				int idTraining = Integer.parseInt(request.getParameter("training"));
				String dateNow = TimeConvert.getDateNow();
				Date dateNow1 = TimeConvert.getDateTime(dateNow);
				System.out.println(idTraining);
				Training objTraining = mTrainning.getItem(idTraining);
				String dateStr = request.getParameter("beginDate");
				Date beginDate = TimeConvert.getDateTime(dateStr);
				if(beginDate.before(dateNow1)){
					response.sendRedirect(request.getContextPath()+"/index?msg=register0");
					return;
				}
				System.out.println(beginDate);
				int no_of_day_to_add = objTraining.getDayTraining();
				Date endDate = new Date( beginDate.getYear(), beginDate.getMonth(),beginDate.getDate() + no_of_day_to_add );
				Users objUserInRegister = mRegister.getIdUser(objUser.getIdUser());
				if(objUserInRegister != null){
					int idRegister = mRegister.getIdRegister(objUserInRegister.getIdUser());
					System.out.println("IDregister:"+idRegister);
					Register objRegis1 = new Register(idRegister, idUsers, idTraining, TimeConvert.getSqlDate(beginDate), TimeConvert.getSqlDate(endDate), false);
					if(mRegister.editItem(objRegis1)>0){
						checkUser = 1;
						if(endDate.after(dateNow1) ){
							mRegister.editTypeUsersWhenAdminUpdateEnddate(objUserInRegister.getIdUser());
						}
						response.sendRedirect(request.getContextPath()+"/index?msg=register");
						return;	
					}
					
				}else if(objUserInRegister == null){
					Register objRegis2= new Register(0, idUsers, idTraining, TimeConvert.getSqlDate(beginDate), TimeConvert.getSqlDate(endDate), false);
					if(mRegister.addItem(objRegis2)>0){
						checkUser = 1;
						if(endDate.after(dateNow1) ){
							mRegister.editTypeUsersWhenAdminUpdateEnddate(objUser.getIdUser());
						}
						response.sendRedirect(request.getContextPath()+"/index?msg=register");
						return;
					}
				}
				
			}
			
		}
		System.out.println(checkUser);
		request.setAttribute("alTrainning", mTrainning.getList());
		request.setAttribute("checkUser", checkUser);
		RequestDispatcher rd = request.getRequestDispatcher("/public/registerTrainning.jsp");
		rd.forward(request, response);
	}

	
}
