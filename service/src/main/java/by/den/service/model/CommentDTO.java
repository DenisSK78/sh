package by.den.service.model;

import by.den.model.Comment;
import by.den.service.model.NewsDTO;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

public class CommentDTO {

    private Long id;
    private String comment;
    private Date date;
    private Long idUser;
    private NewsDTO newsDTO;

    public CommentDTO() {
    }

    public CommentDTO(Long id, String comment, Date date, Long idUser, NewsDTO newsDTO) {
        this.id = id;
        this.comment = comment;
        this.date = date;
        this.idUser = idUser;
        this.newsDTO = newsDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public NewsDTO getNewsDTO() {
        return newsDTO;
    }

    public void setNewsDTO(NewsDTO newsDTO) {
        this.newsDTO = newsDTO;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                ", idUser=" + idUser +
                ", newsDTO=" + newsDTO +
                '}';
    }
}
