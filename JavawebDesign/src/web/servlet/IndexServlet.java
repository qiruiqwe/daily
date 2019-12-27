package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDao;

@WebServlet("/task/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    //获取所有Cookie
		    Cookie[] cookies = request.getCookies();
		    //如果浏览器中存在Cookie
		    if (cookies != null && cookies.length > 0) {
		        //遍历所有Cookie
		        for(Cookie cookie: cookies) {
		            //找到name为city的Cookie
		            if (cookie.getName().equals("u_id")) {
		                //使用URLDecode.decode()解码,防止中文乱码
		                String u_id = cookie.getValue();
		                long id = Long.parseLong(u_id);
						System.out.println(id);
		                request.setAttribute("tasks", new TaskDao().findAllById(id));
		                request.setAttribute("years", new TaskDao().findYearsById(id));
		            }
		        }
		    }
		request.getRequestDispatcher("/task/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
