package lk.ijse.instagram.instagram.entity;




import lk.ijse.instagram.instagram.constant.Permissions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Adminuser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private  String password;

    @Enumerated(EnumType.STRING)
    @ElementCollection

    private List<Permissions> permissions=new ArrayList<>();

    public List<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permissions> permissions) {
        this.permissions = permissions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
