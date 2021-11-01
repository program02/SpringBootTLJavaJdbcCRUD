package com.exam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@Controller  //Every-thing operation working with Controller
@RestController
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
	
	
//	//even @ResponseBody this one no need if we use @RestController
//	@RequestMapping("/all")
//	public @ResponseBody List<Student> allstudents(ModelAndView m) {
//		StudentDao dao = new StudentDao();
//		List<Student> list = dao.allStudents();
////		m.addObject("stList", list);
////		m.setViewName("result.html");
////		System.out.println(list.get(0).id);
//		return list;
//	}
	
	
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
	
//	
//	@ResponseBody()
//	//@RequestMapping(value="/showbyid/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//	@RequestMapping(value="/showbyid/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
//	//@RequestMapping(value="/showbyid/{id}", produces = {MediaType.APPLICATION_XML_VALUE}) //need gson library.
//	public Student showbyid(ModelAndView m, @PathVariable("id") int id) {
//		StudentDao dao = new StudentDao();
//		Student st = dao.showbyid(id);
////		List<Student> list = new ArrayList<>();
////		list.add(st);
////		m.addObject("stList", list);
////		m.setViewName("result.html");
//		return st;
//	}
	
	
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
