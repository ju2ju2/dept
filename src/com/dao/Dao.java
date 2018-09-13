package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dto.Dto;


public class Dao {
	
	private JdbcTemplate jdbctemplate;
	
	@Autowired
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

   public List<Dto> searchAll() throws SQLException{
      
      String sql = "select DEPTNO,DNAME,LOC from DEPT";
      
      return this.jdbctemplate.query(sql, new BeanPropertyRowMapper<Dto>(Dto.class));

   }
   //update에 필요한 search
   public Dto search(int deptno) throws SQLException{
	      
	      String sql = "select DEPTNO,DNAME,LOC from DEPT where deptno=?";
	      
	      return this.jdbctemplate.queryForObject(sql,
                  new BeanPropertyRowMapper<Dto>(Dto.class),deptno);

	   }
   
   public boolean insert(int deptno,String dname, String loc) throws SQLException{
	   boolean result = false;
	   
	   String sql = "insert into dept(deptno, dname, loc) values(?,?,?)";
	   Object[] params = {deptno,dname,loc};
	   if(this.jdbctemplate.update(sql,params) > 0)
		{
			result = true;
		}
	   
	   return result;
	   
	}
   
   public boolean update(Dto dto) throws SQLException{
	   boolean result = false;
	   
	   String sql = "update dept set dname=?, loc=? where deptno=?";
	   Object[] params = {dto.getDname(),dto.getLoc(),dto.getDeptno()};
	   if(this.jdbctemplate.update(sql,params) > 0)
		{
			result = true;
		}
	   
	   return result;
	}
   
   public int delete(int deptno) throws SQLException{
	      
	      String sql = "delete from dept where deptno=?";
	      
		return jdbctemplate.update(sql, deptno);

	   }
   
   
}