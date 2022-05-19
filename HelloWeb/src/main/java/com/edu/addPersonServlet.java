package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addPersonServlet")
public class addPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public addPersonServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("uid");
		String name = request.getParameter("uname");
		String score = request.getParameter("uscore");
		String age = request.getParameter("uage");
		
		System.out.println("���̵�: " + id);
		System.out.println("�̸�: " + name);
		System.out.println("����: " + score);
		System.out.println("����: " + age);
		
		PrintWriter out = response.getWriter(); // InputStream, OutputStream, ReadStream
		out.println("<h3>������</h3>");
		out.println("<h4>ID:" + id + "</h4>");
		out.println("<h4>Name:" + name + "</h4>");
		out.println("<h4>Score:" + score + "</h4>");
		out.println("<h4>age:" + age + "</h4>");
		
	}

}
