package by.den.service.model;

import by.den.model.Goods;

import java.math.BigDecimal;
import java.util.List;

public class GoodsDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Integer invNumber;
    private Boolean softDelete;
    private List<BuyDTO> buyList;

    public GoodsDTO() {
    }

    public GoodsDTO(Long id, String name, BigDecimal price, String description, Integer invNumber, Boolean softDelete, List<BuyDTO> buyList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.invNumber = invNumber;
        this.softDelete = softDelete;
        this.buyList = buyList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getInvNumber() {
        return invNumber;
    }

    public void setInvNumber(Integer invNumber) {
        this.invNumber = invNumber;
    }

    public Boolean getSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(Boolean softDelete) {
        this.softDelete = softDelete;
    }

    public List<BuyDTO> getBuyList() {
        return buyList;
    }

    public void setBuyList(List<BuyDTO> buyList) {
        this.buyList = buyList;
    }

    @Override
    public String toString() {
        return "GoodsDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", invNumber=" + invNumber +
                ", softDelete=" + softDelete +
                ", buyList=" + buyList +
                '}';
    }
}
