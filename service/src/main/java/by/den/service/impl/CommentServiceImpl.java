package by.den.service.impl;

import by.den.dao.impl.CommentDAOImpl;
import by.den.dao.impl.NewsDAOImpl;
import by.den.model.Comment;
import by.den.service.converter.CommentConverter;
import by.den.service.model.CommentDTO;
import by.den.service.model.NewsDTO;
import by.den.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl {

    @Autowired
    private CommentDAOImpl commentDAOImpl;

    @Autowired
    private DateServiceImpl dateImpl;

    private CommentDTO comment;
    private Comment commentRep;

    @Transactional
    public void addNewComment(NewsDTO newsDTO, Long idUser, CommentDTO comment){
        commentRep = new Comment();
        this.comment = comment;
        comment.setComment(comment.getComment());
        comment.setIdUser(idUser);
        comment.setNewsDTO(newsDTO);
        comment.setDate(dateImpl.getDateNowFromDatabase());
        commentRep = CommentConverter.commentDTOtoComment(comment);
        commentDAOImpl.save(commentRep);
    }

    @Transactional
    public Boolean deleteComment(Long id){
        Boolean delete;
        try {
            commentRep = commentDAOImpl.findById(id);
            commentDAOImpl.delete(commentRep);
            return delete=true;
        }catch (Exception ex){
            return delete=false;
        }
    }
}
