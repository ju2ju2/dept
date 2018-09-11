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

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method="post";
		doProcess(request, response, method);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
		System.out.println("요청방식 : " + method);
		Dao dao=new Dao();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int deptno = Integer.parseInt(request.getParameter("deptno"));
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
		try {
			int result=dao.updateData(deptno, dname, loc);	
			if(result>0) {
				System.out.println("update 성공");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/list");
				dispatcher.forward(request, response);
			  }else{
				  System.out.println("update 실패");
				  RequestDispatcher dispatcher = request.getRequestDispatcher("/list");
				  dispatcher.forward(request, response);
			  }
		}catch(SQLException e) {e.printStackTrace();}
	}
}
