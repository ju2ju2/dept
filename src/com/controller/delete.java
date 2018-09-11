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
 * Servlet implementation class Delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

    public delete() {
        super();
    }
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String method="get";
      doProcess(request, response, method);
   
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String method="post";
      doProcess(request, response, method);
   
   }
   
   protected void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
      System.out.println("요청방식 : " + method);
      Dao dao=new Dao();
      int deptno = 0;
      String dname = null;
      String loc = null;
      try {
         int deleterow=0;
         deptno = Integer.parseInt(request.getParameter("deptno"));
         dname = request.getParameter("dname");
         loc = request.getParameter("loc");
         deleterow=dao.deleteData(deptno, dname, loc);
         if(deleterow>0) {
        	 RequestDispatcher dispatcher = request.getRequestDispatcher("/list");
             dispatcher.forward(request, response);
         }
      }catch(SQLException e) {e.printStackTrace();}
   }
   
   
   

}