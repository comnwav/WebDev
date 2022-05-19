package co.edu.todo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/ToDoServlet")
public class ToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ToDoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");

		ToDoDAO dao = new ToDoDAO();
		dao.getList();
		List<ToDo> list = dao.getList();

		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String atr = request.getParameter("atr");

		ToDoDAO dao = new ToDoDAO();

		if (atr.equals("add")) {
			String cont = request.getParameter("cont");
			String check = request.getParameter("checked");

			ToDo td = new ToDo();
			td.setCont(cont);
			td.setCheck(Integer.parseInt(check));
			dao.addEvent(td);

		} else if (atr.equals("delete")) {
			String cont = request.getParameter("cont");
			dao.delTodo(cont);
			
		} else if (atr.equals("checked")) {
			String checked = request.getParameter("checked");
			dao.checkTodo(checked);
		}

	}

}
