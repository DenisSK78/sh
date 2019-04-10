package by.den.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StatusBuy {
    @RequestMapping(value = "/edit/buy-status", method = RequestMethod.GET)
    public String buyStatus(ModelMap model) {
        model.addAttribute("sms", "let's work");
        return "/edit/buy-status";
    }
}
