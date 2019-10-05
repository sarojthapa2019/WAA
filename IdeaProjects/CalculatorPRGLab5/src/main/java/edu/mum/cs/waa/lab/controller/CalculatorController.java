package edu.mum.cs.waa.lab.controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import edu.mum.cs.waa.lab.domain.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class CalculatorController {

    @RequestMapping
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/showform")
    public String showForm(){
        return "calculator";
    }
    
    @PostMapping({"/calculate"})
    public String calculate(Calculator calculator, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        List<String> errors = new ArrayList<>();
        String sum, product;
        if(!bindingResult.hasErrors()){
            try {
                Integer add1 = calculator.getAdd1();
                Integer add2 = calculator.getAdd2();
                sum = ""+(add1 + add2);
                calculator.setSum(sum);
            }
            catch (Exception e){
                e.printStackTrace();
                errors.add("Cannot add empty field");
                sum = "";
                calculator.setSum(sum);
            }
            try{
                Integer mult1 = calculator.getMult1();
                Integer mult2 = calculator.getMult2();
                product = ""+(mult1*mult2);
                calculator.setProduct(product);

            }catch (Exception e){
                e.printStackTrace();
                errors.add("Cannot multiply empty field");
                product = "";
                calculator.setProduct(product);
            }
            redirectAttributes.addFlashAttribute("errors", errors);

            redirectAttributes.addFlashAttribute("calculator", calculator);
            return"redirect:/result";

        }
        else{
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("calculator", calculator);
            return "redirect:/result";
        }
    }
    @GetMapping("/result")
    public ModelAndView showResult(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");
        return modelAndView;
    }
}
