package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/downloadAction")
public class downloadAction extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String fileName=request.getParameter("file");
		System.out.println(fileName);
		String directory=this.getServletContext().getRealPath("/upload");
		File file=new File(directory+"/"+fileName);
		
		String mimeType=getServletContext().getMimeType(file.toString());
		if(mimeType==null) {
			response.setContentType("application/octet-stream");
		}
		
		String downloadName=null;
//		if(request.getHeader("user-agent").indexOf("MSIE")==-1) {//인터넷 익스플로가아니면 파일형식 바꿔줌
//			downloadName=new String(fileName.getBytes("UTF-8"),"8859_1");//8859-1 데이터안꺠지고 잘 전달
//		}else {
//			downloadName=new String(fileName.getBytes("EUC-KR"),"8859_1");	
//		}
//		downloadName=new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
//		downloadName=new String(request.getParameter(fileName).getBytes("iso-8859-1"),"utf-8");
		downloadName=URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+", "%20");
		
		response.setHeader("Content-Disposition", "attachment;filename=\""+downloadName+"\";");
		
		FileInputStream fileInputStream=new FileInputStream(file);
		ServletOutputStream servletOutputStream=response.getOutputStream();
		
		byte b[]=new byte[1024];
		int data=0;
		while((data=(fileInputStream.read(b,0,b.length)))!=-1) {
			servletOutputStream.write(b,0,data);
		}
		
		servletOutputStream.flush();
		servletOutputStream.close();
		fileInputStream.close();
	}


}
