package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDao;
import entity.Task;
import util.Pagination;

@WebServlet("/task/tasklist")
public class TasklistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String number = request.getParameter("number"); // 用户的页号起始于1
		String size = request.getParameter("size");
		Pagination<Task> pagination = new Pagination<>();
		pagination.setUri(request.getRequestURI());
		try {
			pagination.setNumber(Integer.parseInt(number) - 1);
		} catch (NumberFormatException e) {
		}
		
		try {
			pagination.setSize(Integer.parseInt(size));
		} catch (NumberFormatException e) {
		}
		request.setAttribute("pagination", new TaskDao().findAll(pagination));
		request.getRequestDispatcher("tasklist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
