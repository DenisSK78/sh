package by.den.service.converter;

import by.den.model.News;
import by.den.model.User;
import by.den.service.model.NewsDTO;
import by.den.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static by.den.service.converter.CommentConverter.commentListToComentListDTO;

@Service
public class NewsConverter {

    @Autowired
    DateConverter dateConverter;

    public static List<NewsDTO> newsListTonewsListDTO(List<News> newsList) {
        List<NewsDTO> newsListDTO = new ArrayList<>();
        for(News news:newsList){
            newsListDTO.add(newsToNewsDTO(news));
        }
        return newsListDTO;
    }

    public static NewsDTO newsToNewsDTO(News news){
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setId(news.getId());
        newsDTO.setName(news.getName());
        newsDTO.setText(news.getText());
        newsDTO.setDate(news.getDate());
        newsDTO.setPics(news.getPics());
        newsDTO.setAuthor(news.getAuthor());
        newsDTO.setPath(news.getPath());
        newsDTO.setCommentList(commentListToComentListDTO(news.getCommentList()));
        return newsDTO;
    }

    public static News newsDTOtoNews(NewsDTO newsDTO){
        News news = new News();
        news.setId(newsDTO.getId());
        news.setName(newsDTO.getName());
        news.setText(newsDTO.getText());
        if (newsDTO.getUserDTO()!=null) {
            news.setUser(UserConverter.userDTOtoUser(newsDTO.getUserDTO()));
        }
        news.setDate(newsDTO.getDate());
        news.setPics(newsDTO.getPics());
        news.setAuthor(newsDTO.getAuthor());
        news.setPath(newsDTO.getPath());
        return news;
    }
}
