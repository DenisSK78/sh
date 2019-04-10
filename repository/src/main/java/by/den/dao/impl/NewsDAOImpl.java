package by.den.dao.impl;

import by.den.dao.NewsDAO;
import by.den.model.News;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsDAOImpl extends GenericDAOImpl<News, Long> implements NewsDAO {


    public List<News> getNewsFromView(Integer countObject, Integer page){
        List<News> newsList;
        Criteria criteria = getSession().createCriteria(News.class);
        criteria.addOrder(Order.desc("id"));
        int firstResult = page*countObject;
        criteria.setFirstResult(firstResult);//------------------
        criteria.setMaxResults(countObject);//--------------------
        newsList = criteria.list();
        return newsList;
    }

//    public Long getLast(){
//        List newsList;
//        Criteria criteria = getSession().createCriteria(News.class);
//        criteria.addOrder(Order.desc("id"));
//        criteria.setFirstResult(1);//------------------
//        criteria.setMaxResults(1);//--------------------
//        newsList = criteria.list();
//        System.out.println(newsList);
//        return (Long) newsList.get(0);
//    }

}
