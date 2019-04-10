package by.den.model;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.sql.JDBCType.BINARY;
import static java.sql.JDBCType.BLOB;

@Entity
@Table(name = "T_NEWS")
public class News implements Serializable {

    private static final long serialVersionUID = 5L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_news")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "text", columnDefinition = "TEXT")
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date")
    private Date date;

    @Column(name = "pics")
    private String pics;

    @Column(name = "author")
    private String author;

    @Column(name = "path")
    private String path;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @OneToMany(mappedBy = "news", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Comment> commentList = new ArrayList<>();

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", pics='" + pics + '\'' +
                ", author='" + author + '\'' +
                ", path='" + path + '\'' +
                ", user=" + user +
                ", commentList=" + commentList +
                '}';
    }
}
