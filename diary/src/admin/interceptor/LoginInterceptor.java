package admin.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		
		// 获取请求的url
				String url = request.getRequestURI();
				// 判断url是否是公开地址(实际使用时将公开地址配置到配置文件中)
				if (url.indexOf("login.action") >= 0) {
					// 如果要进行登录提交，放行
					return true;
				}

				// 判断session
				HttpSession session = request.getSession();
				// 从session中取出用户份信息
				String username = (String) session.getAttribute("username");

				if (username != null) {
					// 身份存在，放行
					return true;
				}
				// 执行这里表示用户身份需要验证，跳转到登录界面
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(
						request, response);
				// return false表示拦截，不向下执行
				// return true表示放行
				return false;
		}
}

