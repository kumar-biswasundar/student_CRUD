package com.cglia.sms.controller;

import java.util.List;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cglia.sms.model.Student;
import com.cglia.sms.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

@Controller(value="smsController")
public class SMSController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping({"/","/home"})
	public String showHome() {
		return "Home";
	}
	@GetMapping("/add")
	public String addStudent(HttpServletRequest request) {
		return "Student";
	}
	//To-Do     ---double posting problem
	@RequestMapping(path="/save", method=RequestMethod.POST)
	public String saveStudent(@ModelAttribute Student student, HttpServletRequest request, RedirectAttributes attrs) {
		System.out.println(student);
		Integer rollNo=service.saveStudent(student);
		attrs.addFlashAttribute("studentRollNo", rollNo); 
		
		
		if(rollNo>0) {
			attrs.addFlashAttribute("successmsg","Student saved successfully with RollNo:"+rollNo);
		}else {
			attrs.addFlashAttribute("failuremsg","An error occurred. Please try again...");
		}
		
		return "redirect:/getAll";
	}
	@RequestMapping(path="/getAll", method=RequestMethod.GET)
	public String getAllStudent(HttpServletRequest request) {
		List<Student> studentList=service.getAllStudents();
		
		request.setAttribute("studentList", studentList);
		System.out.println(studentList);
		return "ShowAllStudent";
	}
	@GetMapping("/getStudent")
	public String getStudentByRollNo(@RequestParam("rollNo") Integer rollNo, HttpServletRequest request) {
		
		Student student=service.getStudentByRollNo(rollNo);
		request.setAttribute("student",student);
		return "UpdateStudent";
		
	}
	
	@PostMapping("/update")
	public String updateStudent(@ModelAttribute Student student, RedirectAttributes attrs) {
		int count=service.updateStudent(student);
		attrs.addFlashAttribute("updatecount", count);
		if(count>0) {
			attrs.addFlashAttribute("updated","Student with RollNo: "+student.getRollNo()+" is updated successfully.");
		}else {
			attrs.addFlashAttribute("notupdated","An error occurred. Please try again...");
		}
		return "redirect:/getAll";
		
	}
	
	@PostMapping("/delete")
	public String deleteStudent(HttpServletRequest request, RedirectAttributes attrs) {
		Integer rollNo=null;
		int count=0;
		if(Objects.nonNull(request.getParameter("rollNotodelete"))) {
			rollNo=Integer.parseInt(request.getParameter("rollNotodelete"));
		}
		if(Objects.nonNull(rollNo)) {
			count=service.deleteStudentByRollNo(rollNo);
			attrs.addFlashAttribute("deletecount", count);
		}
		
		if(count>0) {
			attrs.addFlashAttribute("deleted","Student with RollNo: "+rollNo+" is deleted successfully.");
		}else {
			attrs.addFlashAttribute("notdeleted","An error occurred. Please try again...");
		}
		return "redirect:/getAll";
		
	}
	
}
