package by.den.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(ModelMap model) {
        model.addAttribute("sms", "let's work");
        return "index";
    }
}
