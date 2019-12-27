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

@WebServlet("/task/userpass")
public class UserPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserPassServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String u_id =null;
		String password = null;
		String username = null;
		// 获取所有Cookie
		Cookie[] cookies = request.getCookies();
		// 如果浏览器中存在Cookie
		if (cookies != null && cookies.length > 0) {
			// 遍历所有Cookie
			for (Cookie cookie : cookies) {
				// 找到name为city的Cookie
				if (cookie.getName().equals("u_id")) {
					// 使用URLDecode.decode()解码,防止中文乱码
					u_id = cookie.getValue();
				} else if (cookie.getName().equals("username")) {
					// 使用URLDecode.decode()解码,防止中文乱码
					username = cookie.getValue();
				} else if (cookie.getName().equals("password")) {
					// 使用URLDecode.decode()解码,防止中文乱码
					password = cookie.getValue();
				}
			}
		}
		request.setAttribute("u_id", u_id);
		request.setAttribute("password", password);
		request.setAttribute("username", username);
		request.getRequestDispatcher("/task/userinfor.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = 0;
		User user = new User();
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch (NumberFormatException e) {
			System.out.println("id解析出错！！");
		}
		String username = request.getParameter("username");
		String password = request.getParameter("newpassword1");
		user.setId(id);
		user.setName(username);
		user.setPassword(password);
		new UserDao().update(user);
		response.sendRedirect(request.getContextPath() + "/task/userpass");
	}

}
