package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDao;
import entity.Task;

@WebServlet("/task/edit")
public class TaskEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public TaskEditServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = 0;
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch (NumberFormatException e) {
			System.out.println("ID解析错误！！");
		}
		Task task = new TaskDao().findById(id);
		if (task == null) {
			response.sendRedirect(request.getContextPath() + "/task/tasklist");
		} else {
			request.setAttribute("task", task);	
			request.getRequestDispatcher("/task/edit.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long t_id =0;
		Task Task = new Task();
		// 接收表单数据，封装到Task对象中，并调用dao.edit(task)将数据写入数据库
		String date = request.getParameter("date");
		String[] dates = date.split("-");
		try {
			t_id = Long.parseLong(request.getParameter("t_id"));
			System.out.println(t_id);
		} catch (NumberFormatException e) {
			System.err.println("用户ID解析异常");
		}
		Task.setId(t_id);
		Task.setInformation(request.getParameter("information"));
		Task.setYear(Long.parseLong(dates[0]));
		Task.setMonth(Long.parseLong(dates[1]));
		Task.setDay(Long.parseLong(dates[2]));
		Task = new TaskDao().update(Task);
		System.out.println("");
		response.sendRedirect(request.getContextPath() + "/task/tasklist");
	}

}
