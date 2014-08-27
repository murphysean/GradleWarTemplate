package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(filterName = "headerCheckFilter",
		displayName = "Header Check Filter",
		description = "Adds HTTP Accept Header to all requests that didn't present one",
		urlPatterns = "/*")
public class HeaderCheckFilter implements Filter{
	private Logger logger = Logger.getLogger(this.getClass().getName());

	public HeaderCheckFilter(){
		logger.info("Header Check Filter Instantiated");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException{
		logger.info("Access Control Filter Initialized");
	}

	@Override
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException, ServletException{
		logger.info("Header Check Filter Do Filter");
		if(request instanceof HttpServletRequest && response instanceof HttpServletResponse){
			if(((HttpServletRequest)request).getHeader("Accept") == null){
				final HttpServletRequest httpServletRequest = (HttpServletRequest)request;
				HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(httpServletRequest){
					@Override
					public String getHeader(String name){
						if(name.toLowerCase().equals("accept"))
							if(super.getHeader(name) == null)
								return "application/json";
						return super.getHeader(name);
					}
				};
			}
		}
		chain.doFilter(request,response);
	}

	@Override
	public void destroy(){
		logger.info("Header Check Filter Destroyed");
	}
}
