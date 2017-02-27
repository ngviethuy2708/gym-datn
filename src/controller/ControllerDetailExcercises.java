package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelExcercises;
import model.ModelIntroduce;

/**
 * Servlet implementation class ControllerDetailIntroduces
 */
public class ControllerDetailExcercises extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDetailExcercises() {
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
		ModelExcercises mEx = new ModelExcercises();
		int eid = 0;
		if(request.getParameter("eid")!= null){
			eid = Integer.parseInt(request.getParameter("eid"));
		}
		request.setAttribute("objEx", mEx.getItem(eid));
		RequestDispatcher rd = request.getRequestDispatcher("/public/detailExcercises.jsp");
		rd.forward(request, response);
		
	}

}
