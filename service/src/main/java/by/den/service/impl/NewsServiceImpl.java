package by.den.service.impl;

import by.den.dao.impl.NewsDAOImpl;
import by.den.model.Comment;
import by.den.model.News;
import by.den.service.converter.CommentConverter;
import by.den.service.converter.NewsConverter;
import by.den.service.model.CommentDTO;
import by.den.service.model.NewsDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

@Service
public class NewsServiceImpl {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private NewsDAOImpl newsDAOImpl;

    @Autowired
    private PegesServiceCount pegesCount;

    @Autowired
    private DateServiceImpl dateService;

    @Autowired
    private Environment environment;

    @Autowired
    private FileDeleteService fileDeleteService;

    private List<NewsDTO> newsDTOList;
    private News news;

    @Transactional
    public List<NewsDTO> getAllNews(){
        List<News> newsList = newsDAOImpl.findAll();
        newsDTOList = NewsConverter.newsListTonewsListDTO(newsList);
        return newsDTOList;
    }

    @Transactional
    public List<NewsDTO> getNewsByView(Integer pageNumber){
        List<News> newsList = newsDAOImpl.getNewsFromView(3,pageNumber);
        newsDTOList = NewsConverter.newsListTonewsListDTO(newsList);
        for (NewsDTO newsDTO: newsDTOList){
            newsDTO.setCountCommets(newsDTO.getCommentList().size());
        }
        return newsDTOList;
    }

    @Transactional
    public Integer getCountPagesNews(){
        Integer countNews = getAllNews().size();
        return pegesCount.countPages(countNews, 3);
    }

    @Transactional
    public NewsDTO getNewsById(Long id){
        news = newsDAOImpl.findById(id);
        NewsDTO newsDTO = NewsConverter.newsToNewsDTO(news);
        newsDTO.setCountCommets(news.getCommentList().size());
        List<Comment> commentList=news.getCommentList();
        List<CommentDTO> commentDTOList = CommentConverter.commentListToComentListDTO(commentList);
        newsDTO.setCommentList(commentDTOList);
        return newsDTO;
    }

    @Transactional
    public void deleteNewsId(Long id){
        News news = newsDAOImpl.findById(id);
        if (news!=null) {
            try {
                newsDAOImpl.delete(news);
                logger.info(" / Delete news id: "+news.getId());
                File path = new File(environment.getProperty("files.path.news")).getCanonicalFile();
                fileDeleteService.deleteFile(path, news.getId());
            } catch (Exception e){//------------------------
                logger.error("Mistake news deleted!",e);
            }
        }
    }

    @Transactional
    public NewsDTO saveNews(NewsDTO newsDTO){
        try {
            news = NewsConverter.newsDTOtoNews(newsDTO);
            news.setDate(dateService.getDateNowFromDatabase());
            newsDAOImpl.save(news);
            newsDTO = NewsConverter.newsToNewsDTO(news);
            return newsDTO;
        }catch (Exception e){//------------------------
            logger.error("News does not save!",e);
            return null;
        }
    }

    @Transactional
    public Boolean updateNews(NewsDTO newsDTO){
        try {
        if (newsDTO.getCommentList()==null){
            News news = newsDAOImpl.findById(newsDTO.getId());
            news.setName(newsDTO.getName());
            news.setText(newsDTO.getText());
            news.setAuthor(newsDTO.getAuthor());
            newsDAOImpl.saveOrUpdate(news);
            return true;
        }else {
            newsDAOImpl.saveOrUpdate(NewsConverter.newsDTOtoNews(newsDTO));
            return true;
        }
        }catch (Exception e){//------------------------
            logger.error("News does not update!",e);
            return false;
        }
    }

    @Transactional
    public Boolean deletePics(NewsDTO newsDTO){
        try {
            File path = new File(environment.getProperty("files.path.news")).getCanonicalFile();
            fileDeleteService.deleteFile(path, newsDTO.getId());
            newsDTO.setPics(null);
            newsDAOImpl.saveOrUpdate(NewsConverter.newsDTOtoNews(newsDTO));
            return true;
        }catch (Exception e) {
            logger.error("Delete pics in service error!",e);
            return false;
        }
    }
}
