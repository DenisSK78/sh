package by.den.dao.impl;

import by.den.dao.AddressDAO;
import by.den.model.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAOImpl extends GenericDAOImpl<Address, Long> implements AddressDAO {
}
