package com.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.Dao;
import com.dto.Dto;

@Controller
public class deptController {
	
	private Dao dao;

	@Autowired
	public void setNoticedao(Dao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/list.do")
	public String deptList(Model model) throws SQLException {
		List<Dto> dtoList = dao.searchAll();
		model.addAttribute("dtoList", dtoList);
		return "list";
	}

	//delete 입니다
	@RequestMapping(value="/delete.do", method=RequestMethod.GET)
		public String deptList(int deptno, Model model) throws SQLException {
		dao.delete(deptno);
		return "redirect:list.do";
	}
	
}
