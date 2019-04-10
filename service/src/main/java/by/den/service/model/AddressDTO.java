package by.den.service.model;

import by.den.model.Address;

public class AddressDTO {

    private Long idUser;
    private String country;
    private String sity;
    private String street;
    private Integer house;
    private String building;
    private Integer flat;
    private UserDTO userDTO;

    public AddressDTO() {
    }

    public AddressDTO(Long idUser, String country, String sity, String street, Integer house, String building, Integer flat, UserDTO userDTO) {
        this.idUser = idUser;
        this.country = country;
        this.sity = sity;
        this.street = street;
        this.house = house;
        this.building = building;
        this.flat = flat;
        this.userDTO = userDTO;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "id_User=" + idUser +
                ", country='" + country + '\'' +
                ", sity='" + sity + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", building='" + building + '\'' +
                ", flat=" + flat +
                '}';
    }
}
