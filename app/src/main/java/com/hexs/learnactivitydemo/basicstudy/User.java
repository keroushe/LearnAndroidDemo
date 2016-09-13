package com.hexs.learnactivitydemo.basicstudy;

import java.io.Serializable;

/**
 * Created by hexs on 16/9/13.
 */
public class User implements Serializable {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "username = " + username + ",password = " + password;
    }
}
