package by.den.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_USER_MSG")
public class UserMsg implements Serializable{

    private static final long serialVersionUID = 7L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_msg")
    private Long id;

    @Column(name = "msg")
    private String msg;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    public UserMsg() {
    }

    public UserMsg(Integer idUser, String msg, User user) {
        this.msg = msg;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
