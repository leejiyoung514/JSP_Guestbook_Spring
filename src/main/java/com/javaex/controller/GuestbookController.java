package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDAO;
import com.javaex.vo.GuestbookVO;

@Controller
public class GuestbookController {
	
    @Autowired
	private GuestbookDAO dao;
    
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute GuestbookVO vo) {
		System.out.println("insert");
		System.out.println(vo.toString());
		dao.insert(vo);
	    return"redirect:/list";
	}
	
	@RequestMapping(value="/deleteform")
	public String deleteform() {
		System.out.println("deleteform");
	   return"/WEB-INF/views/deleteform.jsp";
	}
	
 @RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("no")int no, @RequestParam("password")String password ) {
		System.out.println("delete");
		System.out.println("넘버출력"+no+" "+password);
		int result=dao.delete(no, password);
		System.out.println(result+"건 삭제");
		return"redirect:/list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list");		
		List<GuestbookVO> list =dao.getlist();
		model.addAttribute("list", list);
	   return"/WEB-INF/views/list.jsp";
	}
	
	
}
