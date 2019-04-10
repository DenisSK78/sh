package by.den.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.sql.DataSource;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_BUY")
public class Buy implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_buy")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private String status;

    @Column(name = "cost")
    private BigDecimal cost;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToMany( cascade = {CascadeType.ALL})
    @JoinTable( name = "t_buy_goods",
            joinColumns = {@JoinColumn(name = "id_buy")},
            inverseJoinColumns ={@JoinColumn(name = "id_goods")}
    )
    private List<Goods> goodsList = new  ArrayList<>();

    public Buy() {
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

    //    public void setDate() {
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        Date date = new Date();
//        dateFormat.format(date);
//        long time = date.getTime();
//        this.date = new Timestamp(time);
//    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public void addGoods(Goods goods){
        goodsList.add(goods);
    }

    @Override
    public String toString() {
        return "Buy{" +
                "id=" + id +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", cost=" + cost +
                '}';
    }
}