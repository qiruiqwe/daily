package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkCode = request.getParameter("checkCode");

		User user = new UserDao().login(username, password);
		
		if (user != null) {
			String u_id = Long.toString(user.getId());
			System.out.println(u_id);
			if (checkCode.equals(request.getSession().getAttribute("checkCode"))) {
				// // 将用户名及密码作为Cookie存储到浏览器缓存中
				Cookie usernameCookie = new Cookie("username", username);
				Cookie passwordCookie = new Cookie("password", password);
				Cookie uidCookie = new Cookie("u_id", u_id);
				// // 设置Cookie的寿命为两周
				usernameCookie.setMaxAge(60 * 60 * 24 * 14);
				passwordCookie.setMaxAge(60 * 60 * 24 * 14);
				uidCookie.setMaxAge(60 * 60 * 24 * 14);
				response.addCookie(usernameCookie);
				response.addCookie(passwordCookie);
				response.addCookie(uidCookie);
				// }
				// 将已登录用户的信息存储到服务器的Session对象中
//				HttpSession session = request.getSession();
//				session.setAttribute("loggedUser", username);
//				request.getRequestDispatcher("index").forward(request, response);
				response.sendRedirect("task/index");
				return;
			} else {
				request.setAttribute("msg", "验证码错误，请重新输入");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			//
		} else {
			request.setAttribute("msg", "用户名或密码错误，请重新输入");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
