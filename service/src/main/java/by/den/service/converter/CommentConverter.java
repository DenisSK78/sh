package by.den.service.converter;

import by.den.dao.CommentDAO;
import by.den.model.Comment;
import by.den.model.News;
import by.den.service.model.CommentDTO;
import by.den.service.model.NewsDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentConverter {


    private Comment comment;

    public static List<CommentDTO> commentListToComentListDTO(List<Comment> commentList) {
        List<CommentDTO> commentListDTO = new ArrayList<>();
        for (Comment comment: commentList){
            commentListDTO.add(commentToCommentDTO(comment));
        }
        return commentListDTO;
    }

    public static Comment commentDTOtoComment(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setComment(commentDTO.getComment());
        comment.setDate(commentDTO.getDate());
        comment.setIdUser(commentDTO.getIdUser());
        comment.setNews(NewsConverter.newsDTOtoNews(commentDTO.getNewsDTO()));
        return comment;
    }

    public static CommentDTO commentToCommentDTO(Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setComment(comment.getComment());
        commentDTO.setDate(comment.getDate());
        commentDTO.setIdUser(comment.getIdUser());
//        commentDTO.setNewsDTO(NewsConverter.newsToNewsDTO(comment.getNews()));
        return commentDTO;
    }
}
