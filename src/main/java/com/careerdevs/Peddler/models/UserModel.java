package com.careerdevs.Peddler.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Entity
public class UserModel {

    @JsonProperty("Id")
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @JsonProperty("User_Name")
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @JsonProperty("Password")
    @Column(name = "password", nullable = false)
    private String password;

    @JsonProperty("Age")
    @Column(name = "age", nullable = false)
    private int age;

    @JsonProperty("Gender")
    @Column(name = "gender", nullable = false)
    private String gender;

    //O> Figure out relationship mapping between vendor and user

    //X List of Favorite Vendors


    private Set<UUID> favoriteVendors;

    //X List of Previous Vendors

    private Map<Timestamp, UUID> vendorHistory;

    //

    public UserModel() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

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

    public Set<UUID> getFavoriteVendors() { return favoriteVendors; }

    public void addFavoriteVendors(UUID vendorId) { favoriteVendors.add ( vendorId ); }

    public void removeFavoriteVendor(UUID vendorId) { favoriteVendors.remove ( vendorId ); }

    public Map<Timestamp, UUID> getVendorHistory() { return vendorHistory; }

    public void clearVendorHistory(){ vendorHistory.clear (); }

    public void checkInAtVendor(Timestamp timestamp, UUID vendorId) { vendorHistory.put (timestamp, vendorId ); }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"userName\":\"" + userName + '"' +
                ", \"password\":\"" + password + '"' +
                ", \"age\":" + age +
                ", \"gender\":\"" + gender + '"' +
                ", \"favoriteVendors\":" + favoriteVendors +
                ", \"vendorHistory\":" + vendorHistory +
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