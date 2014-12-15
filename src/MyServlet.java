
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

	AtomicInteger idInteger = new AtomicInteger();
	
	private int setSessionId(HttpSession ses){
		int id = idInteger.getAndIncrement();
		ses.setAttribute("ID", id);
		return id;
	}
	private int getSessionId(HttpSession ses) {
		Object id = ses.getAttribute("ID");
		if(id instanceof Integer){
			return (int)id;
		}else {
			return -1;
		}
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException 
	{
		int id;
		String str = "";
		try{HttpSession ses = req.getSession();
		if(ses.isNew()){
			id = setSessionId(ses);
			str = "Welcome new user! You id is " + id;
		}else {
			id = getSessionId(ses);
			str = "Hi again! You id is " + id;
		}
		}
		catch(IllegalStateException ex){
			System.out.println("Excep" + ex);
		}
		resp.setContentType("text/html; charset = utf-8");
		resp.setStatus(HttpServletResponse.SC_OK);
		PrintWriter out = resp.getWriter();
		out.println(PageGenerator.generateHtmlCode());
		out.println("<h1>"+ str + "</h1>");
		out.close();
		
	}
	

}
