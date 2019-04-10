package by.den.service.model;


import by.den.model.News;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class NewsDTO {

    private Long id;
    private String name;
    private String text;
    private Date date;
    private String pics;
    private String author;
    private String path;
    private UserDTO userDTO;
    private Integer countCommets;
    private List<CommentDTO> commentList;

    public NewsDTO() {
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public Integer getCountCommets() {
        return countCommets;
    }

    public void setCountCommets(Integer countCommets) {
        this.countCommets = countCommets;
    }

    public List<CommentDTO> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentDTO> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "NewsDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", pics='" + pics + '\'' +
                ", author='" + author + '\'' +
                ", path='" + path + '\'' +
                ", userDTO=" + userDTO +
                ", countCommets=" + countCommets +
                ", commentList=" + commentList +
                '}';
    }
}
