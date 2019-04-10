package by.den.dao.impl;

import by.den.dao.BuyDAO;
import by.den.model.Buy;
import org.springframework.stereotype.Repository;

@Repository
public class BuyDAOImpl extends GenericDAOImpl<Buy, Long> implements BuyDAO {
}
