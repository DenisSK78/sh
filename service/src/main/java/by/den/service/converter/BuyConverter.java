package by.den.service.converter;

import by.den.model.Buy;
import by.den.service.model.BuyDTO;
import by.den.service.model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuyConverter {

    public static List<BuyDTO> buyListTobuyListDTO(List<Buy> buyList) {
        List<BuyDTO> buyListDTO = new ArrayList<>();
        for (Buy buy:buyList){
            buyListDTO.add(buyToBuyDTO(buy));
        }
        return buyListDTO;
    }

    public static BuyDTO buyToBuyDTO(Buy buy){
        BuyDTO buyDTO = new BuyDTO();
        buyDTO.setId(buy.getId());
        buyDTO.setDate(buy.getDate());
        buyDTO.setStatus(buy.getStatus());
        buyDTO.setCost(buy.getCost());
        buyDTO.setUserDTO(UserConverter.userToUserDTO(buy.getUser()));
        return buyDTO;
    }

}
