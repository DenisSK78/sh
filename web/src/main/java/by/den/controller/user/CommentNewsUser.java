package by.den.controller.user;

import by.den.model.UserPrincipal;
import by.den.service.converter.DateConverter;
import by.den.service.impl.CommentServiceImpl;
import by.den.service.impl.NewsServiceImpl;
import by.den.service.model.CommentDTO;
import by.den.service.model.NewsDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class CommentNewsUser {

    private static final Logger logger = Logger.getLogger(CommentNewsUser.class);

    @Autowired
    private NewsServiceImpl newsService;

    @Autowired
    private CommentServiceImpl commentService;

    private NewsDTO newsDTO;

    @GetMapping(value = "/news-comment{id}")
    public String print(ModelMap model, @RequestParam(value = "id") Long id) {
        newsDTO = newsService.getNewsById(id);
        newsDTO.setDate(DateConverter.toWeb(newsDTO.getDate()));
        model.addAttribute("news", newsDTO);
        return "user/news-comment";
    }

    @PostMapping(value = "/news-commentPost")
    public String newComment(@Valid @ModelAttribute("comment")CommentDTO commentDTO,
                             BindingResult result, Authentication authentication){
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        commentService.addNewComment(newsDTO, userPrincipal.getID(), commentDTO);
        return "redirect:/user/news-comment?id="+newsDTO.getId();
    }
}
//@Valid dosn't work!!
//BindingResult from error valid.