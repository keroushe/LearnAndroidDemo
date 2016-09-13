package com.hexs.learnactivitydemo.basicstudy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hexs on 16/9/13.
 */
public class Student implements Parcelable {

    private String username;
    private String password;
    private int id;

    public Student(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "username = " + username + ",password = " + password + ",id = " + id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        bundle.putString("username", username);
        bundle.putString("password", password);
        dest.writeBundle(bundle);
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {

        public Student createFromParcel(Parcel source) {
            Bundle bundle = source.readBundle();
            return new Student(bundle.getString("username"), bundle.getString("password"), bundle.getInt("id"));
        }

        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
