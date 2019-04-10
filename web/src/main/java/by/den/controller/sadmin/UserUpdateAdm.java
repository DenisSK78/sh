package by.den.controller.sadmin;

import by.den.service.impl.UserServiceImpl;
import by.den.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserUpdateAdm {

    @Autowired
    UserServiceImpl userService;

    private UserDTO userDTO;

    @RequestMapping(value = "sadmin/user-update", method = RequestMethod.GET)
    public String print(ModelMap model, HttpServletRequest request) {
        userDTO = userService.getById(Long.valueOf(request.getParameter("id")));
        model.addAttribute("user", userDTO);
        return "sadmin/user-update";
    }
}
