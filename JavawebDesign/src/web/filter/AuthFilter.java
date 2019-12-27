package web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

/**
 * @author LAB 登录过滤器，对/task/* 进行登录过滤，如果没有登录，就转到登录页
 *
 */
//@WebFilter("/task/index")
@WebFilter(urlPatterns = {"/task/index","/task/edit","/task/add","/task/delete","/task/tasklist","/task/userpass"})
public class AuthFilter implements Filter {

	public AuthFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		// 判断是否已经登录，
		if (httpServletRequest.getSession().getAttribute("loggedUser") != null) {
			// 判断是否已经登录，
			chain.doFilter(request, response);
		} else {
			// 如果未登录
			// 利用Cookie数据进行登录功能，略
			String username = new String();
			String password = new String();
			Cookie[] cookies = httpServletRequest.getCookies();
			// 如果浏览器中存在Cookie
			if (cookies != null && cookies.length > 0) {
				// 遍历所有Cookie
				for (Cookie cookie : cookies) {
					// 找到name为city的Cookie
					if (cookie.getName().equals("username")) {
						// 使用URLDecode.decode()解码,防止中文乱码
						username = cookie.getValue();
						System.out.println(username);
					} else if (cookie.getName().equals("password")) {
						// 使用URLDecode.decode()解码,防止中文乱码
						password = cookie.getValue();
						System.out.println(password);
					}
				}
			}
			// 试图从Cookie中获取用户名及密码，并登
			User user = new UserDao().login(username, password);
			System.out.println(user);
			// 如果登录失败，转到登录页面
			// 如果登录成功，直接往下传递
			if (user != null) {
				chain.doFilter(request, response);
				return;
			}
			String requestURI = httpServletRequest.getRequestURI();
			System.out.println(this.getClass().getSimpleName() + "拦截了" + requestURI);
			HttpServletResponse httpServletResponse = (HttpServletResponse)response;
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
			return;
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
