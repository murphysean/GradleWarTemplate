package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(filterName = "accessControlFilter",
		displayName = "Access Control Filter",
		description = "Adds HTTP Headers to all responses to allow cross domain requests",
		urlPatterns = "/*")
public class AccessControlFilter implements Filter{
	private Logger logger = Logger.getLogger(this.getClass().getName());

	public AccessControlFilter(){
		logger.info("Access Control Filter Instantiated");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException{
		logger.info("Access Control Filter Initialized");
	}

	@Override
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException, ServletException{
		logger.info("Access Control Filter Do Filter");
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = ((HttpServletResponse)response);

		String origin = httpServletRequest.getHeader("Origin");
		if(origin != null && httpServletRequest.getLocalPort() != 80)
			origin.concat(Integer.toString(httpServletRequest.getLocalPort()));
		String method = httpServletRequest.getHeader("Access-Control-Request-Method");
		String headers = httpServletRequest.getHeader("Access-Control-Request-Headers");

		if(origin != null)
			httpServletResponse.addHeader("Access-Control-Allow-Origin",origin);
		if(method != null)
			httpServletResponse.addHeader("Access-Control-Allow-Methods",method);
		if(headers != null)
			httpServletResponse.addHeader("Access-Control-Allow-Headers",headers);

		httpServletResponse.addHeader("Access-Control-Allow-Credentials","true");
		httpServletResponse.addHeader("Access-Control-Expose-Headers","Location");
		httpServletResponse.addHeader("Access-Control-Max-Age","3600");

		chain.doFilter(request,response);
	}

	@Override
	public void destroy(){
		logger.info("Access Control Filter Destroyed");
	}
}
