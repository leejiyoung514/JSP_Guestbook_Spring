package com.javaex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookDao dao;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute GuestbookVo vo) {
		System.out.println("insert");
		System.out.println(vo.toString());
		int count = dao.insert(vo);
		System.out.println(count + " 건 등록");
		return "redirect:/list";
	}

	/*
	 * @RequestMapping(value="/deleteform/{no}") public String deleteform(Model
	 * model, @PathVariable("no") int no) { //화면에 보내야해서 모델에 담아서
	 * model.addAttribute("no", no); //model 객체 에 담으면 디스패처 서블릿에서 알아서 꺼내서 request에
	 * 담아서 jsp에 전달 System.out.println("deleteform");
	 * return"/WEB-INF/views/deleteform.jsp"; //디스패처 서블릿이 뷰가 누구인지 알려주고 리턴 }
	 */

	@RequestMapping(value = "/deleteform")
	public String deleteform() {
		System.out.println("deleteform");
		return "/WEB-INF/views/deleteform.jsp";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("no") int no, @RequestParam("password") String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("password", password);
		System.out.println("delete");
		System.out.println("넘버출력" + no + " " + password);
		int result = dao.delete(map);
		System.out.println(result + "건 삭제");
		return "redirect:/list";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list");
		List<GuestbookVo> list = dao.getlist();
		model.addAttribute("list", list);
		return "/WEB-INF/views/list.jsp";
	}

}
