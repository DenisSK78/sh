package by.den.service.model;

import by.den.model.Buy;
import by.den.model.Goods;
import by.den.service.model.GoodsDTO;
import by.den.service.model.UserDTO;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BuyDTO {

    private Long id;
    private Date date;
    private String status;
    private BigDecimal cost;
    private UserDTO userDTO;
    private List<GoodsDTO> goodsDTOList;

    public BuyDTO() {
    }

    public BuyDTO(Long id, Timestamp date, String status, BigDecimal cost, UserDTO userDTO, List<GoodsDTO> goodsDTOList) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.cost = cost;
        this.userDTO = userDTO;
        this.goodsDTOList = goodsDTOList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<GoodsDTO> getGoodsDTOList() {
        return goodsDTOList;
    }

    public void setGoodsDTOList(List<GoodsDTO> goodsDTOList) {
        this.goodsDTOList = goodsDTOList;
    }

    @Override
    public String toString() {
        return "BuyDTO{" +
                "id=" + id +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", cost=" + cost +
                ", goodsDTOList=" + goodsDTOList +
                '}';
    }
}