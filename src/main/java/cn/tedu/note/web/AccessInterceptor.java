package cn.tedu.note.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tedu.note.controller.JsonResult;
import cn.tedu.note.entity.User;
@Component
//创建成bean
public class AccessInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		String path=req.getRequestURI();
		
		//如果没有登录就返回错误的json消息
		//如果登录了就放过请求
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginUser");
		if(user==null){
			JsonResult result = new JsonResult("需要重新登录！");
			//利用response对象反馈结果
			res.setContentType("application/json;charset=utf-8");
			res.setCharacterEncoding("utf-8");
			//
			ObjectMapper mapper = new ObjectMapper();
			String json =mapper.writeValueAsString(result);
			res.getWriter().println(json);
			res.flushBuffer();
			//  // --//之间的代码就素responseBody的代码
			return false;
		}
		return true;//放过请求
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		

	}

}
