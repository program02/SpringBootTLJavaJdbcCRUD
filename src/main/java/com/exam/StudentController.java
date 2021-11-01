package com.exam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	@RequestMapping("/")
	public ModelAndView home(ModelAndView m) {
		StudentDao dao = new StudentDao();
		m.setViewName("home.html");
		return m;
	}
	
	@RequestMapping("/all")
	public ModelAndView allstudents(ModelAndView m) {
		StudentDao dao = new StudentDao();
		List<Student> list = dao.allStudents();
		m.addObject("stList", list);
		m.setViewName("result.html");
		System.out.println(list.get(0).id);
		return m;
	}
	
	@RequestMapping("/showbyid")
	public ModelAndView showbyid(ModelAndView m,Student s) {
		StudentDao dao = new StudentDao();
		Student st = dao.showbyid(s.id);
		List<Student> list = new ArrayList<>();
		list.add(st);
		m.addObject("stList", list);
		m.setViewName("result.html");
		return m;
	}
	@RequestMapping("/insert")
	public ModelAndView insert(ModelAndView m,Student s) {
		StudentDao dao = new StudentDao();
		dao.insert(s);
		List<Student> list = dao.allStudents();
		m.addObject("stList", list);
		m.setViewName("result.html");
		return m;
	}
	@RequestMapping("/update")
	public ModelAndView update(ModelAndView m,Student s) {
		StudentDao dao = new StudentDao();
		dao.update(s);
		List<Student> list = dao.allStudents();
		m.addObject("stList", list);
		m.setViewName("result.html");
		return m;
	}
	@RequestMapping("/updatef")
	public ModelAndView updatef(ModelAndView m,Student s) {
		m.addObject("s", s);
		m.setViewName("updatef.html");
		return m;
	}
	@RequestMapping("/deletebyid")
	public ModelAndView deletebyid(ModelAndView m,Student s) {
		StudentDao dao = new StudentDao();
		dao.deletebyid(s.id);
		List<Student> list = dao.allStudents();
		m.addObject("stList", list);
		m.setViewName("result.html");
		return m;
	}
}
