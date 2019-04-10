package by.den.dao.impl;

import by.den.dao.CommentDAO;
import by.den.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAOImpl extends GenericDAOImpl<Comment,Long> implements CommentDAO {
}
