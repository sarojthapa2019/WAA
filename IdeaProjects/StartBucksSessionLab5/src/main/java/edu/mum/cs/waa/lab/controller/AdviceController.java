package edu.mum.cs.waa.lab.controller;

import edu.mum.cs.waa.lab.domain.Advice;
import edu.mum.cs.waa.lab.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class AdviceController {
    private AdviceService adviceService;
    @Autowired
    public AdviceController(AdviceService adviceService){
        this.adviceService = adviceService;
    }

    @GetMapping("/advice")
    public String showAdvicePage(Model model){
        model.addAttribute("roasts",adviceService.getAllAdviceKey());
        return "advice";
    }
    @PostMapping("/advice")
    public String display(Advice advice, Model model){
        String type = advice.getType();
        model.addAttribute("roast", type);
        model.addAttribute("roastList",adviceService.getAdviceByType(type));
        return "display";
    }

}
