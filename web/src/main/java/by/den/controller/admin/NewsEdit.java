package by.den.controller.admin;

import by.den.model.UserPrincipal;
import by.den.service.impl.*;
import by.den.service.model.NewsDTO;
import by.den.service.model.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class NewsEdit {

    private static final Logger logger = Logger.getLogger(NewsEdit.class);

    @Autowired
    private NewsServiceImpl newsService;

    @Autowired
    private FileSaveService fileSaveService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private FileDeleteService fileDeleteService;

    @Autowired
    Environment environment;

    @GetMapping(value = "/edit/news-edit")
    public String newsEdit(@RequestParam(value = "delete", defaultValue = "") Integer id, ModelMap model ) {
        if (id!=null){
            newsService.deleteNewsId(Long.valueOf(id));
            model.addAttribute("msg", "News deleted!");
        }
        List<NewsDTO> newsDTOList = newsService.getAllNews();
        model.addAttribute("newsDTO", newsDTOList);
        return "/edit/news-edit";
    }

    @GetMapping(value = "/edit/news-update")
    public String newsEditUpdate(ModelMap model, HttpServletRequest request) {
        NewsDTO newsDTO = newsService.getNewsById(Long.valueOf(request.getParameter("id")));
        model.addAttribute("msg", request.getParameter("msg"));
        model.addAttribute("newsDTO", newsDTO);
        return "/edit/news-update";
    }

    @GetMapping(value = "/edit/add-new-news")
    public String newNews(ModelMap model) {
        model.addAttribute("msg", model.get("msg"));
        return "/edit/add-new-news";
    }

    @PostMapping("/edit/add-new-news/upload")
    public String saveNews(@RequestParam("file") MultipartFile file,  Authentication authentication,
                             @Valid @ModelAttribute("news") NewsDTO newsDTO, BindingResult bindingResult,
                             Model model, HttpServletRequest request) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        newsDTO.setUserDTO(userService.getById(userPrincipal.getID()));
        NewsDTO newsDTOSave = newsService.saveNews(newsDTO);
        if (newsDTOSave != null) {
            if (!file.getOriginalFilename().isEmpty() && file.getSize()>0) {
                if (file.getSize() > 1048576){
                    model.addAttribute("msg", "News saved but file was not save, it is larger than 1MB!");
                    return "/edit/add-new-news";
                }
                Boolean save = fileSaveService.saveFile(file, newsDTOSave.getId());
                if (save) {
                    newsDTOSave.setUserDTO(userService.getById(userPrincipal.getID()));
                    newsDTOSave.setPics(String.valueOf(newsDTOSave.getId()));
                    boolean update=newsService.updateNews(newsDTOSave);
                } else {
                    model.addAttribute("msg", "File was not upload!");
                }
            }
        } else {
            model.addAttribute("msg", "News does not save!");
        }
        model.addAttribute("msg", "News saved!");
        return "/edit/add-new-news";
    }
//        logger.info(environment.getProperty("files.path"));
//        logger.info(request.getSession().getServletContext().getRealPath("/resources/pics"));//from target folder

    @GetMapping("/edit/news-update/delete")
    public String commentDelete(Model model, HttpServletRequest request) {
        boolean delete;
        delete=commentService.deleteComment(Long.valueOf(request.getParameter("com")));
        if (delete) {
            logger.info(" / news id: " + request.getParameter("id") + " / comment id: " + request.getParameter("com") + " DELETED");
            model.addAttribute("msg", "Comment deleted!");
        }else {
            logger.info(" / news id: " + request.getParameter("id") + " / comment id: " + request.getParameter("com") + " DOES NOT DELETE");
            model.addAttribute("msg", "Comment does not delete!");
        }
        return "redirect:/edit/news-update?id="+request.getParameter("id");
    }

    @PostMapping("/edit/news-update")
    public String updateNewsText(Authentication authentication, @Valid @ModelAttribute("news") NewsDTO newsDTO,
                             BindingResult bindingResult, Model model, HttpServletRequest request) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        newsDTO.setId(Long.valueOf(request.getParameter("newsId")));
        newsDTO.setUserDTO(userService.getById(userPrincipal.getID()));
        System.out.println(newsDTO);
        boolean update = newsService.updateNews(newsDTO);
        if (update) {
            logger.info(" / news id: " + request.getParameter("newsId") + " UPDATED");
            model.addAttribute("msg", "News updated!");
        }else {
            logger.info(" / news id: " + request.getParameter("newsId") + " / news id: " + " DOES NOT UPDATE");
            model.addAttribute("msg", "News does not update!");
        }
        return "redirect:/edit/news-update?id="+request.getParameter("newsId");
    }

    @PostMapping("/edit/news-update/add-pics")
    public String picsUpdate(  @RequestParam("file") MultipartFile file,Authentication authentication,
            Model model, HttpServletRequest request) {

        if (!file.getOriginalFilename().isEmpty() && file.getSize()>0) {
            if (file.getSize()>1048576){
                model.addAttribute("msg", "File was not save, it is larger than 1MB!");
                return "redirect:/edit/news-update?id=" + request.getParameter("add");
            }
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            NewsDTO newsDTOSave = newsService.getNewsById(Long.valueOf(request.getParameter("add")));
            Boolean save = fileSaveService.saveFile(file, newsDTOSave.getId());
            if (save) {
                newsDTOSave.setUserDTO(userService.getById(userPrincipal.getID()));
                newsDTOSave.setPics(String.valueOf(newsDTOSave.getId()));
                boolean update=newsService.updateNews(newsDTOSave);
                model.addAttribute("msg", "Pics saved!");
            } else {
                model.addAttribute("msg", "File was not upload!");
            }
        }
        return "redirect:/edit/news-update?id=" + request.getParameter("add");
    }

    @PostMapping("/edit/news-update/del-pics")
    public String picsDelete(  Authentication authentication, Model model, HttpServletRequest request,
                               @Valid @ModelAttribute("news") NewsDTO newsDTO, BindingResult bindingResult) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        newsDTO = newsService.getNewsById(Long.valueOf(request.getParameter("del")));
        if (!newsDTO.getPics().isEmpty()) {
            newsDTO = newsService.getNewsById(Long.valueOf(request.getParameter("del")));
            UserDTO userDTO = userService.getById(userPrincipal.getID());
            newsDTO.setUserDTO(userDTO);
            boolean delPics = newsService.deletePics(newsDTO);
            if (delPics){
                model.addAttribute("msg", "Pics deleted!");
            }else {
                model.addAttribute("msg", "Pics was not delete!");
            }
        }
        return "redirect:/edit/news-update?id=" + request.getParameter("del");
    }
}


