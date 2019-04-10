package by.den.service.converter;

import by.den.model.UserMsg;
import by.den.service.model.UserMsgDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMsgConverter {

    public static List<UserMsgDTO> userMsgListToUserMsgDTO(List<UserMsg> userMsgList) {
        List<UserMsgDTO> userMsgListDTO = new ArrayList<>();
        for (UserMsg userMsg: userMsgList){
            userMsgListDTO.add(userMsgToUserMsgDTO(userMsg));
        }
        return userMsgListDTO;
    }

    public static UserMsgDTO userMsgToUserMsgDTO(UserMsg userMsg){
        UserMsgDTO userMsgDTO = new UserMsgDTO();
        userMsgDTO.setId(userMsg.getId());
        userMsgDTO.setMsg(userMsg.getMsg());
        userMsgDTO.setUserDTO(UserConverter.userToUserDTO(userMsg.getUser()));
        return userMsgDTO;
    }
}
