package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDao;
import entity.Task;

@WebServlet("/task/add")
public class TaskAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public TaskAddServlet() {
		super();
	}

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
	                request.setAttribute("u_id", u_id);
	            }
	        }
	    }
			request.getRequestDispatcher("/task/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收表单数据，封装到Task对象中，并调用dao.edit(task)将数据写入数据库
		long u_id = 0;
		Task Task = new Task();
		String date = null;
		if(request.getParameter("date") =="")
			date="2018-12-11";
		else
			date= request.getParameter("date");
		String[] dates = date.split("-");
		u_id = Long.parseLong(request.getParameter("u_id"));
		System.out.println(u_id);
		Task.setUser_id(u_id);
		Task.setInformation(request.getParameter("information"));
		Task.setYear(Long.parseLong(dates[0]));
		Task.setMonth(Long.parseLong(dates[1]));
		Task.setDay(Long.parseLong(dates[2]));
		Task = new TaskDao().add(Task);
		if(Task != null)
		{
			response.sendRedirect(request.getContextPath() + "/task/tasklist");
			return;
		}
		else {
			response.sendRedirect(request.getContextPath() + "/task/add");
			return;
		}
			
	}

}
