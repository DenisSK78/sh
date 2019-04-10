package by.den.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_USER")
public class User implements Serializable {

    private static final long serialVersionUID = 6L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "info")
    private String info;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserMsg> userMsgList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<News> newsList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Buy> buyList = new ArrayList<>();

    public User() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<UserMsg> getUserMsgList() {
        return userMsgList;
    }

    public void setUserMsgList(List<UserMsg> userMsgList) {
        this.userMsgList = userMsgList;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public List<Buy> getBuyList() {
        return buyList;
    }

    public void setBuyList(List<Buy> buyList) {
        this.buyList = buyList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", info='" + info + '\'' +
                ", address=" + address +
                ", userMsgList=" + userMsgList.toString() +
                ", newsList=" + newsList.toString() +
                ", buyList=" + buyList.toString() +
                '}';
    }
}
