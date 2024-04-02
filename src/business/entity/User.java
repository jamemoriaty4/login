package business.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private int userId;
    private String fullName, username,password, email, phone, address;
    private Date updatedAt , createdAt;
    private boolean role;
    private Status Status;

    public User() {
    }

    public User(int userId, String fullName, String username, String password, String email, String phone, String address, Date updatedAt, Date createdAt, boolean role, business.entity.Status status) {
        this.userId = userId;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.role = role;
        Status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public business.entity.Status getStatus() {
        return Status;
    }

    public void setStatus(business.entity.Status status) {
        Status = status;
    }
}
