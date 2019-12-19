package edu.mum.cs.ormrelationships.onetoone.controller;

import edu.mum.cs.ormrelationships.onetoone.domain.Phone;
import edu.mum.cs.ormrelationships.onetoone.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/phone")
public class PhoneController {

	@Autowired
	PhoneService phoneService;

	@GetMapping("/add")
	public String inputProduct(@ModelAttribute Phone phone) {
		return "onetoone/PhoneForm";
	}

	@PostMapping("/add")
	public String saveProduct(Phone phone) {

		// ....Demo Cascade
		// Best practice on bidirectional set BOTH ends ["Pretend" no DB]
		phone.getProduct().setHotLine(phone);
		phone = phoneService.save(phone); // insert & [ insert OR Update of phone]

		return "onetoone/PhoneDetails";
	}

}
