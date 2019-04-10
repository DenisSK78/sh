package by.den.dao.impl;

import by.den.dao.UserDAO;
import by.den.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends GenericDAOImpl<User, Long> implements UserDAO {

    public User findByName(String login) {
        User user;
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        user = (User) criteria.uniqueResult();
        return user;
    }
}
