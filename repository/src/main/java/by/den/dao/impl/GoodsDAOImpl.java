package by.den.dao.impl;

import by.den.dao.GoodsDAO;
import by.den.model.Goods;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDAOImpl extends GenericDAOImpl<Goods, Long> implements GoodsDAO {
}
