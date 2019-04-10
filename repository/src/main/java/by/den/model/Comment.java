package by.den.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "T_COMMENT")
public class Comment implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private Long id;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date")
    private Date date;

    @Column(name = "id_user")
    private Long idUser;

    @ManyToOne
    @JoinColumn(name = "id_news", nullable = false)
    private News news;

    public Comment() {
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

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
