package com.careerdevs.Peddler.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class VendorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false, unique = true )
    private Long id;

    @JsonProperty("Name")
    @Column(name = "Vendor_Name", nullable = false, unique = true)
    private String vendorName;

//    @Column(name = "Email", nullable = false, unique = true)
//    private String email;
//
//    @Column(name = "Password", nullable = false)
//    private String password;

    @JsonProperty("Desc")
    @Column(name = "Description")
    private String description;

//    @Column(name = "isOpened", nullable = false)
//    private boolean openClosed;
//
//    private VendorVendibles Vending;
//
//    private VendorMobility Mobility;
//
//    private List<VendibleModel> Inventory;
//
//    private List<SpaceTimeModel> SpaceTimeList;

    @JsonProperty("Lat")
    @Column(name = "Latitude")
    private Double lat;

    @JsonProperty("Log")
    @Column(name = "Longitude")
    private Double log;


    public VendorModel() {
    }


    public void setLocation(double lat, double log) {
        this.lat = lat;
        this.log = log;
    }


    public Double getLog() {
        return log;
    }

    public void setLog(Double log) {
        this.log = log;
    }


    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Long getId() {
        return id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public VendorVendibles getVending() {
//        return Vending;
//    }
//
//    public void setVending(VendorVendibles vending) {
//        Vending = vending;
//    }
//
//    public VendorMobility getMobility() {
//        return Mobility;
//    }
//
//    public void setMobility(VendorMobility mobility) {
//        Mobility = mobility;
//    }
//
//    public boolean isOpenClosed() {
//        return openClosed;
//    }
//
//    public void setOpenClosed(boolean openClosed) {
//        this.openClosed = openClosed;
//    }
//
//    public List<VendibleModel> getInventory() {
//        return Inventory;
//    }
//
//    public List<SpaceTimeModel> getSpaceTimeList() {
//        return SpaceTimeList;
//    }


    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"vendorName\":\"" + vendorName + '"' +
                ", \"description\":\"" + description + '"' +
                ", \"lat\":" + lat +
                ", \"log\":" + log +
                '}';
    }
}
/*
- ID
- Truck Name
- Location
- Menu
- Schedule
- Wares
- On/Off Location? i forgot what this was supposed to be
- Open Closed
*/
