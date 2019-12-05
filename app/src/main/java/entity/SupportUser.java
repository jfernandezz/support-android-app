package entity;

import java.io.Serializable;

public class SupportUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    private String username;
    private String  role;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    
    
}
