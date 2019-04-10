package by.den.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoodsEdit {
    @RequestMapping(value = "/edit/goods-edit", method = RequestMethod.GET)
    public String goodsEdit(ModelMap model) {
        model.addAttribute("sms", "let's work");
        return "/edit/goods-edit";
    }
}
