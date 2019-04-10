package by.den.controller.sadmin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SuperAdminMain {
    @RequestMapping(value = "/sadmin/main", method = RequestMethod.GET)
    public String main(ModelMap model) {
        model.addAttribute("sms", "let's work");
        return "/sadmin/main";
    }
}
