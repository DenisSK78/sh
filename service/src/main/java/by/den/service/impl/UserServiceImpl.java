package by.den.service.impl;

import by.den.dao.impl.UserDAOImpl;
import by.den.model.User;
import by.den.service.converter.UserConverter;
import by.den.service.model.UserDTO;
import by.den.service.model.UserSecurutyDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDAOImpl userDAOimpl;

    private List<UserDTO> userDTOList = null;
    private UserDTO userDTO;
    private UserSecurutyDTO userSecurutyDTO;

    @Transactional
    public List<UserDTO> getAll() {
        List<User> userList = userDAOimpl.findAll();
        userDTOList = UserConverter.userListToUserListDTO(userList);
        return userDTOList;
    }

    @Transactional
    public UserDTO getById(Long id){
        userDTO = UserConverter.userToUserDTO(userDAOimpl.findById(id));
        return userDTO;
    }

    @Transactional
    public UserSecurutyDTO getFromSecurity(String login){
        User userDAO = userDAOimpl.findByName(login);
        if(userDAO!=null){
            userSecurutyDTO = new UserSecurutyDTO(userDAO);
            logger.info("/---------/"+userSecurutyDTO.getRole()+" - id: "+userSecurutyDTO.getId());
            return userSecurutyDTO;
        }
        return userSecurutyDTO;
    }
}

