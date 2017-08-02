package cn.tedu.note.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.note.entity.User;

/**
 * Servlet Filter implementation class DemoFilter
 */
public class AccessFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AccessFilter() {
       
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	private String login="/log_in.html";
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//从请求重获取 请求的url
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session=req.getSession();
		String path = req.getRequestURI();
		if(path.endsWith(login)){
			chain.doFilter(request, response);
			return;
		}
		if(path.endsWith("alert_error/html")){
			chain.doFilter(request, response);
			return;
		}
		
		//检查用户是否登录
		User user = (User) session.getAttribute("loginUser");
		if(user==null){
			//用绝对路径重定向，安全
			res.sendRedirect(req.getContextPath()+login);
			return;
		}
		chain.doFilter(request, response);//这个方法的意义是调用后续的请求
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
