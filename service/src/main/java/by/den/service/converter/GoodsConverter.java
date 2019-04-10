package by.den.service.converter;

import by.den.model.Goods;
import by.den.service.model.GoodsDTO;
import org.springframework.stereotype.Service;

@Service
public class GoodsConverter {


    public GoodsDTO goodsToGoodsDTO(Goods goods){
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setId(goods.getId());
        goodsDTO.setName(goods.getName());
        goodsDTO.setPrice(goods.getPrice());
        goodsDTO.setDescription(goods.getDescription());
        goodsDTO.setInvNumber(goods.getInvNumber());
        goodsDTO.setSoftDelete(goods.getSoftDelete());
        return goodsDTO;
    }
}
