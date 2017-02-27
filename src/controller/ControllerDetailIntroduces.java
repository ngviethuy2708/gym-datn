package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelIntroduce;

/**
 * Servlet implementation class ControllerDetailIntroduces
 */
public class ControllerDetailIntroduces extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDetailIntroduces() {
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
		if(request.getParameter("iid")!= null){
			iid = Integer.parseInt(request.getParameter("iid"));
		}
		request.setAttribute("objIntro", mIntro.getItem(iid));
		RequestDispatcher rd = request.getRequestDispatcher("/public/detailIntroduce.jsp");
		rd.forward(request, response);
		
	}

}
