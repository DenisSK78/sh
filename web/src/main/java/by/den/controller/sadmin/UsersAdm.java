package by.den.controller.sadmin;

import by.den.service.impl.UserServiceImpl;
import by.den.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UsersAdm {

    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping(value = "sadmin/users", method = RequestMethod.GET)
    public String print(ModelMap model) {
        List<UserDTO> userDTOList = userServiceImpl.getAll();
        model.addAttribute("users", userDTOList);
        return "sadmin/users";
    }
}
