package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.language.bm.Rule.Phoneme;
import org.apache.jena.iri.impl.Force;

import library.LibraryPerPuclic;
import model.ModelProduct;
import bean.Product;
import bean.Users;

/**
 * Servlet implementation class ControllerAjaxBuyProduct
 */

public class ControllerAjaxBuyProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAjaxBuyProduct() {
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
		HttpSession ss = request.getSession();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		ModelProduct mPro = new ModelProduct();
		PrintWriter out = response.getWriter();
		String Cart = "";
		int id = Integer.valueOf(request.getParameter("aid"));
		String name = request.getParameter("aname");
		String picture = request.getParameter("apicture");
		int price = Integer.valueOf(request.getParameter("aprice"));
		int number = Integer.valueOf(request.getParameter("anumber"));
		int priceBuy = number* price;
		Product objProduct = new Product(id, name, price, number, priceBuy, picture);
		boolean check = true;
		ArrayList<Product> alPro = null;
		if(ss.getAttribute("alCart")!=null){
			 alPro = (ArrayList)ss.getAttribute("alCart");
		}else{
			alPro  = new ArrayList<>();
		}
		for (Product objPro : alPro) {
			if(objProduct.getIdProduct()==objPro.getIdProduct()){
				int numberNow = objPro.getNumber()+number;
				int priceNow = numberNow*objPro.getPriceProduct();
				objPro.setNumber(numberNow);
				objPro.setPriceBuy(priceNow);
				check = false;
				break;
			}
		}
		if(check){
			alPro.add(objProduct);
		}
		
		if(alPro != null){
			int tongtien = 0;
			Cart += "<table class = 'table table-bordered' style='margin-top: 24px; margin-left:-14px;'>"
					+ "<thead> "
						+"<tr>"
							+"<th>Sản Phẩm</th>"
							+"<th>Số lượng</th>"
							+"<th>Thành tiền</th>"
						+ "</tr>"
					+ "</thead>"
					+ "<tbody>";
						
						
							for(Product p:alPro){
								tongtien += p.getPriceBuy();
								Cart += "<tr> <td>"+p.getNameProduct()+"</td>"
										+"<td>"+p.getNumber()+"</td>"
										+"<td>"+p.getPriceBuy()+"</td> </tr>";		
							}
							Cart += "<tr><td colspan = 2 style = 'font-weight:bold'>Tổng tiền</td><td>"+tongtien+"</td></tr>";
				Cart+=	
					 "</tbody>"
					+ "</table>";
				Cart+= "<p><a href='"+request.getContextPath()+"/indexCart' style ='font-weight:bold; color:#337AB7; margin-left:30px;'>+ Xem giỏ hàng</a></p>";
		}else{
			Cart += "<span style="+"position: relative; bottom: -6px;left: 64px;>"+"Rỗng,chưa có sản phẩm nào!</span> ";
		}
		out.print(Cart);
		
		ss.setAttribute("alCart", alPro);
		
	}

}
