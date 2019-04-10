package by.den.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Login {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String print(ModelMap model) {
        model.addAttribute("users", "oo");
        return "login";
    }
}
