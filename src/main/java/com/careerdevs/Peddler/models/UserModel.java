package com.careerdevs.Peddler.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class UserModel {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @JsonProperty("UserName")
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @JsonProperty("Age")
    @Column(name = "age", nullable = false)
    private int age;

    @JsonProperty("Gender")
    @Column(name = "gender", nullable = false)
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

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"userName\":\"" + userName + '"' +
                ", \"age\":" + age +
                ", \"gender\":\"" + gender + '"' +
                '}';
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