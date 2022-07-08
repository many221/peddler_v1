package com.careerdevs.Peddler.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class UserModel {

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false, unique = true)
    private UUID id;

    @Column(name = "User_Name", nullable = false, unique = true)
    private String userName;

    @Column(name = "Age", nullable = false)
    private int age;

    @Column(name = "Gender", nullable = false)
    private String gender;

    //X List of Favorite Vendors
    //X List of Previous Vendors
    //


    public UserModel() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
/* Fields
* ID
* Username
* Age
* Gender
* List of Favorite Vendors
* List of Previous Vendors
* */