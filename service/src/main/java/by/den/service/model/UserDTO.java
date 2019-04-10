package by.den.service.model;

import by.den.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public class UserDTO {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private Integer phone;
    private String login;
    private String password;
    private String role;
    private String info;
    private AddressDTO addressDTO;
    private List<UserMsgDTO> userMsgList;
    private List<NewsDTO> newsList;
    private List<BuyDTO> buyList;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String surname, String email, Integer phone, String login, String password, String role, String info, AddressDTO addressDTO, List<UserMsgDTO> userMsgList, List<NewsDTO> newsList, List<BuyDTO> buyList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.login = login;
        this.password = password;
        this.role = role;
        this.info = info;
        this.addressDTO = addressDTO;
        this.userMsgList = userMsgList;
        this.newsList = newsList;
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

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public List<UserMsgDTO> getUserMsgList() {
        return userMsgList;
    }

    public void setUserMsgList(List<UserMsgDTO> userMsgList) {
        this.userMsgList = userMsgList;
    }

    public List<NewsDTO> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsDTO> newsList) {
        this.newsList = newsList;
    }

    public List<BuyDTO> getBuyList() {
        return buyList;
    }

    public void setBuyList(List<BuyDTO> buyList) {
        this.buyList = buyList;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", info='" + info + '\'' +
                ", addressDTO=" + addressDTO +
                ", userMsgList=" + userMsgList +
                ", newsList=" + newsList +
                ", buyList=" + buyList +
                '}';
    }
}
