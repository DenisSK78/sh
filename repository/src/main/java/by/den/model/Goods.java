package by.den.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_GOODS")
public class Goods implements Serializable {

    private static final long serialVersionUID = 4L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_goods")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Column(name = "inv_number")
    private Integer invNumber;

    @Column(name = "soft_delete")
    private Boolean softDelete;

    @ManyToMany(mappedBy = "goodsList")
    private List<Buy> buyList = new ArrayList<>();

    public Goods() {
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

    public List<Buy> getBuyList() {
        return buyList;
    }

    public void setBuyList(List<Buy> buyList) {
        this.buyList = buyList;
    }

    @Override
    public String toString() {
        return "Goods{" +
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
