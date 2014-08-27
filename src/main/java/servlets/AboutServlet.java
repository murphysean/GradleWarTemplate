package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "aboutServlet", urlPatterns = "/about.html")
public class AboutServlet extends HttpServlet{
	private Logger logger = Logger.getLogger(this.getClass().getName());

	public AboutServlet(){
		logger.info("About Servlet Instantiated");
	}

	@Override
	public void init() throws ServletException{
		super.init();
		logger.info("About Servlet Initialized");
	}

	@Override
	public void destroy(){
		super.destroy();
		logger.info("About Servlet Destroyed");
	}

	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		logger.info("About Servlet Do Get");
		request.getRequestDispatcher("about.jsp").forward(request,response);
	}
}
