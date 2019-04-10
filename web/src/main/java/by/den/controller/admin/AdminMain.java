package by.den.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminMain {
    @RequestMapping(value = "/admin/main", method = RequestMethod.GET)
    public String main(ModelMap model) {
        model.addAttribute("sms", "let's work");
        return "/admin/main";
    }
}
