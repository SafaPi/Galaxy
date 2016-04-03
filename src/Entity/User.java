/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Dridi
 */
public class User {

    private int id;
    private String username;
    private String email;
    private String password;
    private String salt;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public User() {
    }

    public User(int id, String username, String email, String password, String salt) {
        this.id = id;
        this.username = username;

        this.email = email;

        this.password = password;
        this.salt = salt;
    }

    public User(String username, String email, String password, String salt) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", password=" + password + ", username=" + username + ", salt=" + salt + '}';
    }

}
