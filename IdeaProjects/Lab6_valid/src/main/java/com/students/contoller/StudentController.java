package com.students.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.students.domain.Student;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
	
	@RequestMapping(value="/registration",method=RequestMethod.GET)	
	    public String showForm(@ModelAttribute("student") Student student, Model model){
		List<String> genderList = new ArrayList<>();
		genderList.add("Male");
		genderList.add("Female");
		model.addAttribute("gender", genderList);
 	        return "registration";
	    }


	
	@RequestMapping(value="/registration",method=RequestMethod.POST)	
	    public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
								  Model model){
 
 			if(bindingResult.hasErrors()){
				return "registration";
			}

             return "success";
 
	
	    }
	    
	}

	

