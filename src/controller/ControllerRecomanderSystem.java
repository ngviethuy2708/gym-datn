package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.base.Sys;

import RecomanderSystems.Matran;
import bean.DanhGia;
import bean.Product;
import bean.Users;
import model.ModelDanhGia;
import model.ModelProduct;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerRecomanderSystem
 */
@WebServlet("/ControllerRecomanderSystem")
public class ControllerRecomanderSystem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerRecomanderSystem() {
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
		ModelUsers mUser = new ModelUsers();
		ModelProduct mPro = new ModelProduct();
		ModelDanhGia mDanhGia = new ModelDanhGia();
		ArrayList<Users> alUser = mUser.getList();
		ArrayList<Product> alProducts = mPro.getList();
		ArrayList<DanhGia> alDanhGias = mDanhGia.getList();
		int m = alUser.size();
		int n = alProducts.size();
		//ma trận dtrain gồm m hàng users và n cột products
		float dTrain[][] = new float[m][n];
		Random rd = new Random();
		for(int i=0;i<m;i++){
			for (int j = 0; j < n; j++) {
				dTrain[i][j] = rd.nextInt(4)+1;
				System.out.print(dTrain[i][j]);
				System.out.print("\t");
			}
			System.out.println("");
		}
	System.out.println("==================================");
		//ma trận dtest gồm m hàng users và n cột products
		float dTest[][] = new float[m][n];
		for(int i=0;i<m;i++){
			for (int j = 0; j < n; j++) {
				for (DanhGia objDanhGia :alDanhGias ) {
					if(objDanhGia.getIdUsers() == alUser.get(i).getIdUser() && objDanhGia.getIdProducts() == alProducts.get(j).getIdProduct()){
						dTest[i][j] = objDanhGia.getDanhGia();
						break;
					}
				}
				System.out.print(dTest[i][j]);
				System.out.print("\t");
			}
			System.out.println("");
		}
		//phân rã ma trận d test thành w và h có chỉ số k = 2
		Matran mt = new Matran(m,n);
		System.out.println("==================================");
		System.out.println("Ma trận W");
		float w[][] = mt.randomMatran(alUser.size(), 2);
		System.out.println("Ma trận H");
		float h[][] = mt.randomMatran(2, alProducts.size());
		//tim chuẩn:
		float oMF = mt.timchuan(w, h, dTrain);
		System.out.println(oMF);
		System.out.println("===================================");
		mt.phanRaMT(w, h, dTrain, dTest);
		
	}

}
