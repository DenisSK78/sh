package by.den.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "t_address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "Generator")
    @GenericGenerator(name = "Generator", strategy = "foreign",
    parameters = @Parameter(value = "user", name = "property"))
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "country")
    private String country;

    @Column(name = "sity")
    private String sity;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private Integer house;

    @Column(name = "building")
    private String building;

    @Column(name = "flat")
    private Integer flat;

    @OneToOne(mappedBy = "address")
    @PrimaryKeyJoinColumn
    private User user;

    public Address() {
    }

    public Address(String country, String sity, String street, Integer house, String building, Integer flat, User user) {
        this.country = country;
        this.sity = sity;
        this.street = street;
        this.house = house;
        this.building = building;
        this.flat = flat;
        this.user = user;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSity() {
        return sity;
    }

    public void setSity(String sity) {
        this.sity = sity;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address{" +
                "idUser=" + idUser +
                ", country='" + country + '\'' +
                ", sity='" + sity + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", building='" + building + '\'' +
                ", flat=" + flat +
                '}';
    }
}
