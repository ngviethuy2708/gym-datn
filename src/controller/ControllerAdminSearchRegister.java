package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.TimeConvert;
import model.ModelHistory;
import model.ModelMember;
import model.ModelRegister;
import model.ModelTraining;
import model.ModelUser;
import bean.DayOff;
import bean.Member;
import bean.SearchForDate;
import bean.Search;
import bean.Training;

/**
 * Servlet implementation class ControllerAdminSearchUsers
 */

public class ControllerAdminSearchRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminSearchRegister() {
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
	/*	ModelRegister mRegis = new ModelRegister();
		TimeConvert cv = new TimeConvert();
		String type = "";
		String something = "";
		if(request.getParameter("submit") != null){
			type = request.getParameter("optradio");
			something = request.getParameter("something");
			System.out.println(something);
			System.out.println(cv.isDate(something));
			
		}
		if(cv.isDate(something) == false){
			String something2 = new String(something.getBytes("ISO-8859-1"), "UTF-8");
			Search item = new Search(type, something2);
			request.setAttribute("alRegis",mRegis.getListForSearch(item) );
		}else{
			Date dateUntil = cv.getDateTime(something);
			java.sql.Date dateSQl = cv.getSqlDate(dateUntil);
			SearchForDate item2 = new SearchForDate(type, dateSQl);
			request.setAttribute("alRegis", mRegis.getListForSearchDate(item2));	
		}
		RequestDispatcher rd = request.getRequestDispatcher("/admin/searchRegister.jsp");
		rd.forward(request, response);*/
		ModelMember mMember = new ModelMember();
		ModelHistory mHistory = new ModelHistory();
		ModelTraining mTraining = new ModelTraining();
		ArrayList<Member> alMember = mMember.getList();
		ArrayList<Member> alExpected = new ArrayList<>();
		ArrayList<Member> alExprired = new ArrayList<>();
		ArrayList<Member> alDayOffMember = new ArrayList<>();
 		if(request.getParameter("submit") != null){
			int value = Integer.parseInt(request.getParameter("sortMember"));
			if(value == 1){
				for(Member objMember:alMember){
					int dayoff = mHistory.getDayOff(objMember.getCurentHistoryId());
					String curentDateStr = TimeConvert.getDateNow();
					Date curentDateUntil = TimeConvert.getDateTime(curentDateStr);
					java.sql.Date curentDateSql = TimeConvert.getSqlDate(curentDateUntil);
					Calendar c = Calendar.getInstance();
					c.set(Calendar.DAY_OF_MONTH,curentDateSql.getDate());
					c.set(Calendar.MONTH, curentDateSql.getMonth());
					c.set(Calendar.YEAR, curentDateSql.getYear() + 1900);
					c.add(Calendar.DAY_OF_MONTH, -3);
					Date endDate = c.getTime();
					java.sql.Date endDateSQL = TimeConvert.getSqlDate(endDate);
					objMember.setEndDay(endDateSQL);
					c.set(Calendar.DAY_OF_MONTH,endDateSQL.getDate());
					c.set(Calendar.MONTH, endDateSQL.getMonth());
					c.set(Calendar.YEAR, endDateSQL.getYear() + 1900);
					c.add(Calendar.DAY_OF_MONTH, -(objMember.getDayOfTraining()+dayoff-6));
					Date expectedDate = c.getTime();
					java.sql.Date expectedDateSql = TimeConvert.getSqlDate(expectedDate);
					objMember.setExpectedDate(expectedDateSql);
					if(TimeConvert.removeTime(objMember.getBeginDay()).equals(TimeConvert.removeTime(expectedDateSql))){
						alExpected.add(objMember);
					}
				}
				for(Member member: alExpected){
					int dayoff = mHistory.getDayOff(member.getCurentHistoryId());
					member.setDayOff(dayoff);
					Calendar c = Calendar.getInstance();
					c.set(Calendar.DAY_OF_MONTH,member.getBeginDay().getDate());
					c.set(Calendar.MONTH, member.getBeginDay().getMonth());
					c.set(Calendar.YEAR, member.getBeginDay().getYear() + 1900);
					c.add(Calendar.DAY_OF_MONTH, member.getDayOfTraining()+member.getDayOff());
					Date endDate = c.getTime();
					java.sql.Date endDateSQL = TimeConvert.getSqlDate(endDate);
					member.setEndDay(endDateSQL);
				}
				request.setAttribute("alExpected", alExpected);
			}if(value == 2){
				for(Member objMember:alMember){
					int dayoff = mHistory.getDayOff(objMember.getCurentHistoryId());
					String curentDateStr = TimeConvert.getDateNow();
					Date curentDateUntil = TimeConvert.getDateTime(curentDateStr);
					java.sql.Date curentDateSql = TimeConvert.getSqlDate(curentDateUntil);
					Calendar c = Calendar.getInstance();
					c.set(Calendar.DAY_OF_MONTH,objMember.getBeginDay().getDate());
					c.set(Calendar.MONTH, objMember.getBeginDay().getMonth());
					c.set(Calendar.YEAR, objMember.getBeginDay().getYear() + 1900);
					c.add(Calendar.DAY_OF_MONTH, objMember.getDayOfTraining()+dayoff);
					Date endDate = c.getTime();
					java.sql.Date endDateSql = TimeConvert.getSqlDate(endDate);
					objMember.setDayOff(dayoff);
					objMember.setEndDay(endDateSql);
					if(TimeConvert.removeTime(objMember.getEndDay()).before(TimeConvert.removeTime(curentDateSql))){
						alExprired.add(objMember);
					}
				}
				request.setAttribute("alExpired", alExprired);
			}if(value == 3){
				ArrayList<DayOff> alDayOff = mHistory.getDayOff();
				String curentDateStr = TimeConvert.getDateNow();
				Date curentDateUntil = TimeConvert.getDateTime(curentDateStr);
				java.sql.Date curentDateSql = TimeConvert.getSqlDate(curentDateUntil);
				for(DayOff objDayOff: alDayOff){
					if((TimeConvert.removeTime(curentDateSql).after(TimeConvert.removeTime(objDayOff.getStart_day())) || TimeConvert.removeTime(curentDateSql).equals(TimeConvert.removeTime(objDayOff.getStart_day()))) && (TimeConvert.removeTime(curentDateSql).before(TimeConvert.removeTime(objDayOff.getEnd_day())) || TimeConvert.removeTime(curentDateSql).equals(TimeConvert.removeTime(objDayOff.getEnd_day())))){
						Member objMember = mMember.getListForDayOff(objDayOff.getHistory_id());
						objMember.setStartDayOff(objDayOff.getStart_day());
						objMember.setEndDayOff(objDayOff.getEnd_day());
						alDayOffMember.add(objMember);
					}
				}
				for(Member objMember:alDayOffMember){
					System.out.println(objMember.toString());
					System.out.println(objMember.getStartDayOff());
					System.out.println(objMember.getEndDayOff());
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("/admin/sortRegister.jsp");
			rd.forward(request, response);
		}
	}

}
