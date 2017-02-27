package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import bean.Introduce;


import model.ModelIntroduce;


/**
 * Servlet implementation class ControllerAdminIndex
 */
//@WebServlet("/ControllerAdminIndex")
public class ControllerAdminEditIntroduce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminEditIntroduce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelIntroduce mIntro = new ModelIntroduce();
		int iid = 0; 
		if(request.getParameter("iid") != null){
			iid = Integer.parseInt(request.getParameter("iid"));
		}
		// TODO Auto-generated method stub
		if("load".equals(request.getParameter("type"))){
			request.setAttribute("objIntro", mIntro.getItem(iid));
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editIntroduce.jsp");
			rd.forward(request, response);
		}else{
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(fileItemFactory);
			List<FileItem> fileItems = null;
			try {
				fileItems = sfu.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String name = "";
			int idIntroduce = 0;
			String preview ="";
			String detail = "";
			String picture = "";
			String pictureOld = "";
			String pictureNew = "";
			for (FileItem fileItem : fileItems) {
				if(fileItem.isFormField()){
					String fileName = fileItem.getFieldName();
					String fileValue = new String(fileItem.getString().getBytes("ISO-8859-1"),"UTF-8");
					switch (fileName) {
					case "nameIntroduce":
						name = fileValue;
						break;
					case "preview":
						preview = fileValue;
						break;
					case "detail":
						detail = fileValue;
						break;
					case "pictureOld":
						pictureOld = fileValue;
						break;
					default:
						break;
					}
				}else{ // nếu là file
					picture = fileItem.getName();
					if(!picture.isEmpty()){ // có upload
						// đổi tên ảnh
						pictureNew = FilenameUtils.getBaseName(picture) + System.nanoTime() + "." + FilenameUtils.getExtension(picture);
						String filePath = request.getServletContext().getRealPath("")+ File.separator + "files" + File.separator + pictureNew;
						File file = new File(filePath);
						try {
							fileItem.write(file);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(request.getServletContext().getRealPath(""));
						String filePathOld = request.getServletContext().getRealPath("") + File.separator + "files" + File.separator
								+ pictureOld;
						System.out.println(filePathOld);
						File fileOld = new File(filePathOld);
						fileOld.delete();
					}else{ // khong upload
					}
				}
			} // hết for
			// insert news into database
			System.out.println(pictureOld);
			Introduce objIntro = new Introduce(iid, name, preview, detail, pictureNew);
			if(mIntro.editItem(objIntro) > 0){
				response.sendRedirect(request.getContextPath() + "/admin/indexIntroduce");
				return ;
			}else{
				response.sendRedirect(request.getContextPath() + "/admin/editIntroduce");
				return ;
			}
		}
	}

}