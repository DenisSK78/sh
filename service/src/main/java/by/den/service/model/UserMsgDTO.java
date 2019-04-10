package by.den.service.model;


public class UserMsgDTO {

    private Long id;
    private String msg;
    private UserDTO userDTO;

    public UserMsgDTO() {
    }

    public UserMsgDTO(Long id, String msg, UserDTO userDTO) {
        this.id = id;
        this.msg = msg;
        this.userDTO = userDTO;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "UserMsgDTO{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                '}';
    }
}
