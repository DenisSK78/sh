package by.den.dao.impl;

import by.den.dao.UserMsgDAO;
import by.den.model.UserMsg;
import org.springframework.stereotype.Repository;

@Repository
public class UserMsgDAOImpl extends GenericDAOImpl<UserMsg, Long> implements UserMsgDAO {
}
