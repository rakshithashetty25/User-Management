package com.usermanagement.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usermanagement.dao.UserDao;
import com.usermanagent.bean.Userbean;


@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		switch(path)
		{
		case "/validate":validateAdmin(request,response);
		break;
		case "/add":getAddUserForm(request,response);
		break;
		case "/list":displayUser(request,response);
		break;
		case "/insert":insertUser(request,response);
		break;
		case "/delete":deleteUser(request,response);
		break;
		case "/edit":selectUserById(request,response);
		break;
		case "/update": updateUser(request,response);
		break;
		default:getAdminPage(request,response);
		break;
		
		}
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String city=request.getParameter("city");
		Userbean u= new Userbean(id, name, email, city);
		UserDao.updateUser(u);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void selectUserById(HttpServletRequest request, HttpServletResponse response) {
	int id=Integer.parseInt(request.getParameter("id"));
	Userbean u=UserDao.selectUser(id);
		request.setAttribute("user", u);
		RequestDispatcher rd=request.getRequestDispatcher("userform.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		UserDao.delete(id);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String city=request.getParameter("city");
		Userbean u=new Userbean(name, email, city);
		UserDao.insertUserDetails(u);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void displayUser(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Userbean> au=UserDao.display();
		request.setAttribute("userlist", au);
		RequestDispatcher rd=request.getRequestDispatcher("userlist.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void getAddUserForm(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd=request.getRequestDispatcher("userform.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void validateAdmin(HttpServletRequest request, HttpServletResponse response) {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		boolean status=UserDao.checkLogin(name, password);
		if(status)
		{
			try {
				response.sendRedirect("list");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			try {
				response.sendRedirect("My");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void getAdminPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("admin.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
