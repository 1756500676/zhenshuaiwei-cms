/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: UserInterceptor.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.interceptor 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月18日 下午3:55:52 
 * @version: V1.0  
 */
package com.zhenshuaiwei.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhenshuaiwei.common.ConstantClass;
import com.zhenshuaiwei.entity.User;

/** 
 * @ClassName: UserInterceptor 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月18日 下午3:55:52  
 */
public class UserInterceptor implements HandlerInterceptor{

	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User) request.getSession().getAttribute(ConstantClass.USER_KEY);
		if (user == null) {
			response.sendRedirect("/user/login");
			return false;
		}
		if (request.getServletPath().contains("admin")) {
			request.setAttribute("error_login", "只有管理员可访问");
			request.getRequestDispatcher("/user/index").forward(request, response);
		}
		return true;
	}
	
	
}
