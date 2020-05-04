package com.kirosys.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kirosys.model.Student;
import com.kirosys.service.StudentService;


@Controller
@RequestMapping("/students/")
public class StudentController {

	private final StudentService studentRepository;

	@Autowired
	public StudentController(StudentService studentRepository) {
		this.studentRepository = studentRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Student student) {
		return "add-student";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("students", studentRepository.getAllEmployeeDetails());
		return "index";
	}

	@PostMapping("add")
	public String addStudent(@Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-student";
		}

		studentRepository.addEmployeeDetails(student);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") String id, Model model) {
		Student student = studentRepository.getEmployeeDetails(id);
		model.addAttribute("student", student);
		return "update-student";
	}

	@PostMapping("update/{id}")
	public String updateStudent(@PathVariable("id") String id, @Valid Student student, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			student.setId(id);
			return "update-student";
		}

		studentRepository.addEmployeeDetails(student);
		model.addAttribute("students", studentRepository.getAllEmployeeDetails());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") String id, Model model) {
		Student student = studentRepository.getEmployeeDetails(id);
		studentRepository.delete(student);
		model.addAttribute("students", studentRepository.getAllEmployeeDetails());
		return "index";
	}
}
