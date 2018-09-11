package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dto.Dto;



public class Dao {
   static DataSource ds;
   Connection conn = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   
   static {
      InitialContext ctx;
      try {
         ctx = new InitialContext();
         Context envctx = (Context)ctx.lookup("java:comp/env"); //기본 설정
         ds = (DataSource)envctx.lookup("/jdbc/oracle"); //context.xml (name="jdbc/oracle")
         
      }catch (Exception e) {
         System.out.println("look up fail : " + e.getMessage());
      }
   }
   
   public ArrayList<Dto> searchAll() throws SQLException{
      conn = ds.getConnection();
      ArrayList<Dto> deptlist = new ArrayList<Dto>();
      try {
      PreparedStatement pstmt = null;
      String sql = "select DEPTNO,DNAME,LOC from DEPT order by DEPTNO";
      pstmt = conn.prepareStatement(sql);
      
      ResultSet rs = pstmt.executeQuery();
      
      while(rs.next()) {
         Dto m = new Dto();
         m.setDeptno(rs.getInt("deptno"));
         m.setDname(rs.getString("dname"));
         m.setLoc(rs.getString("loc"));
         deptlist.add(m);
         
      }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         if(pstmt != null)try { pstmt.close(); }catch(Exception e) {}
         if(conn != null)try { conn.close(); }catch(Exception e) {}
      }
      return deptlist;
      
   }
   
   
public ArrayList<Dto> search(int deptno) throws SQLException{
	  conn = ds.getConnection();
      ArrayList<Dto> deptlist1 = new ArrayList<Dto>();
      try {
      Dto m = new Dto();
      pstmt = null;
      String sql = "select deptno,dname,loc from dept where deptno=?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, deptno);
      rs = pstmt.executeQuery();
   
       
      while(rs.next()) {
         
         m.setDeptno(rs.getInt("deptno"));
         m.setDname(rs.getString("dname"));
         m.setLoc(rs.getString("loc"));
         deptlist1.add(m);
         
      }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         if(pstmt != null)try { pstmt.close(); }catch(Exception e) {}
         if(conn != null)try { conn.close(); }catch(Exception e) {}
      }
      return deptlist1;
      
   }

public int insertData(int deptno,String dname, String loc) throws SQLException{
   int resultrow=0;
   conn = ds.getConnection();
   try {
   String sql = "insert into dept(deptno, dname, loc) values(?,?,?)";
   pstmt = conn.prepareStatement(sql);
   pstmt.setInt(1, deptno);
   pstmt.setString(2, dname);
   pstmt.setString(3, loc);
   resultrow = pstmt.executeUpdate();
   
   
   }catch(Exception e) {
      e.printStackTrace();
   }finally {
      if(pstmt != null)try { pstmt.close(); }catch(Exception e) {}
      if(conn != null)try { conn.close(); }catch(Exception e) {}
   }
   return resultrow;
   
}

public int updateData(int deptno,String dname, String loc) throws SQLException{
	conn = ds.getConnection();
   int resultrow=0;
   try {
   String sql = "update dept set dname=?, loc=? where deptno=?";
   pstmt = conn.prepareStatement(sql);
   pstmt.setString(1, dname);
   pstmt.setString(2, loc);
   pstmt.setInt(3, deptno);
   
   resultrow = pstmt.executeUpdate();
   
   }catch(Exception e) {
      e.printStackTrace();
   }finally {
      if(pstmt != null)try { pstmt.close(); }catch(Exception e) {}
      if(conn != null)try { conn.close(); }catch(Exception e) {}
   }
   return resultrow;
   
}

public int deleteData(int deptno,String dname, String loc) throws SQLException{
	conn = ds.getConnection();
   int resultrow=0;
   try {
   String sql = "delete from dept where deptno=?";
   pstmt = conn.prepareStatement(sql);
   pstmt.setInt(1, deptno);
   
   resultrow = pstmt.executeUpdate();
   
   }catch(Exception e) {
      e.printStackTrace();
   }finally {
      if(pstmt != null)try { pstmt.close(); }catch(Exception e) {}
      if(conn != null)try { conn.close(); }catch(Exception e) {}
   }
   return resultrow;
   
}
public int searchCK(int deptno) throws SQLException{
	  conn = ds.getConnection();
	  int a=0;
    //ArrayList<Dto> deptlist1 = new ArrayList<Dto>();
    try {
    pstmt = null;
    String sql = "select deptno,dname,loc from dept where deptno=?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setInt(1, deptno);
    rs = pstmt.executeQuery();
 
    if(rs.next()) {
    	a=1;
       return a;
    }
    }catch(Exception e) {
       e.printStackTrace();
    }finally {
       if(pstmt != null)try { pstmt.close(); }catch(Exception e) {}
       if(conn != null)try { conn.close(); }catch(Exception e) {}
    }
	return a;
 }
   
}