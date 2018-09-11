package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;
import com.dto.Dto;

import net.sf.json.JSONArray;



/**
 * Servlet implementation class Search
 */
@WebServlet("/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = "get";
		doProcess(request, response, method);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = "post";
		doProcess(request, response, method);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response, String method)
			throws ServletException, IOException {
		System.out.println("요청방식 : " + method);
		
		Dao dao = new Dao();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			if (request.getParameter("type").equals("update")) {
				ArrayList<Dto> deptlist1 = dao.search(Integer.parseInt(request.getParameter("deptno")));
				request.setAttribute("deptno", deptlist1.get(0).getDeptno());
				request.setAttribute("dname", deptlist1.get(0).getDname());
				request.setAttribute("loc", deptlist1.get(0).getLoc());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/update.jsp");
				dispatcher.forward(request, response);
			} else if (request.getParameter("type").equals("search")) {
				ArrayList<Dto> deptlist1 = dao.search(Integer.parseInt(request.getParameter("deptno")));
				/*request.setAttribute("deptlist", deptlist1);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/list.jsp");
				dispatcher.forward(request, response);*/
				JSONArray jsonlist= JSONArray.fromObject(deptlist1);
				System.out.println(jsonlist);
				response.getWriter().print(jsonlist);
			} else if (request.getParameter("type").equals("search1")) {
				System.out.println("type"+request.getParameter("type")+", deptno"+request.getParameter("deptno"));
				int deptlist2 = dao.searchCK(Integer.parseInt(request.getParameter("deptno")));
				System.out.println("deptlist2"+deptlist2);
				if(deptlist2>0) {
					response.getWriter().print("true"); //화면 지정없이 클라이언트한테 뿌려줌
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
