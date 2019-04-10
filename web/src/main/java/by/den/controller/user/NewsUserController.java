package by.den.controller.user;

import by.den.service.impl.NewsServiceImpl;
import by.den.service.model.NewsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class NewsUserController {

    @Autowired
    private NewsServiceImpl newsService;

    @GetMapping(value = "/news")
    public String showNews(ModelMap model, HttpSession session,
                           @RequestParam(value = "page", defaultValue = "0") Integer page) {
        List<NewsDTO> newsDTOList = newsService.getNewsByView(page);
        Integer countPages = newsService.getCountPagesNews();
        session.setAttribute("page", page);
        session.setAttribute("pages", countPages);
        model.addAttribute("news", newsDTOList);
        return "user/news";
    }
}
