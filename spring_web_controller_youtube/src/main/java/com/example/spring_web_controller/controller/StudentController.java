package com.example.spring_web_controller.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring_web_controller.entity.Student;
import com.example.spring_web_controller.entity.repository.StudentRepository;

@Controller
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;

	
	// To view insert page
	@RequestMapping("/insertPage")
	public String insertPage() {
		return "InsertForm";
	}
	
	// To insert data in the database
	@RequestMapping("/insertData")
	public String insertData(Student student,Model map) {
		studentRepository.save(student);
		map.addAttribute("msg","data inserted");
		return "InsertForm";
	}
	
	// To view all data and call the view page
	@RequestMapping("/viewData")
	public String viewData(Model map) {
		List<Student> view = studentRepository.findAll();
		map.addAttribute("data", view);
		return "ViewForm";
	}
	
	//To delete data by id
	@RequestMapping("/deleteBtn")
	public String deleteData(int id, Model model) {
		studentRepository.deleteById(id);
		List<Student> view = studentRepository.findAll();
		model.addAttribute("data", view);
		return "ViewForm";
	}
	
}
