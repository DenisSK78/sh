package by.den.service.converter;

import by.den.model.Buy;
import by.den.model.News;
import by.den.model.User;
import by.den.model.UserMsg;
import by.den.service.impl.UserServiceImpl;
import by.den.service.model.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserConverter {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    public static List<UserDTO> userListToUserListDTO(List<User> users) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user: users){
            logger.info(user.toString());
            userDTOList.add(userToUserDTO(user));
        }
        return userDTOList;
    }

    public static UserDTO userToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        userDTO.setInfo(user.getInfo());
        userDTO.setAddressDTO(AddressConverter.addressToAddressDTO(user.getAddress()));
        return userDTO;
    }

    public static User userDTOtoUser(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());//----------------------------------
        return user;
    }
}
