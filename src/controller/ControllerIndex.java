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

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import bean.Register;
import library.LibraryConstant;
import library.LibraryPer;
import library.TimeConvert;
import model.ModelBill;
import model.ModelExcercises;
import model.ModelIntroduce;
import model.ModelNews;
import model.ModelProduct;
import model.ModelRegister;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerAdminIndexUsers
 */

public class ControllerIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerIndex() {
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
		ModelNews mNews = new ModelNews();
		ModelProduct mPro = new ModelProduct();
		ModelExcercises mEX = new ModelExcercises();
		request.setAttribute("alIntro", mIntro.getListForPublic());
		request.setAttribute("alNews", mNews.getListForPublic());
		request.setAttribute("alPro", mPro.getListForPublic());
		RequestDispatcher rd = request.getRequestDispatcher("/public/index.jsp");
		rd.forward(request, response);
	}

}
