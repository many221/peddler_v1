package com.careerdevs.Peddler.models;

import com.careerdevs.Peddler.util.Location;
import com.careerdevs.Peddler.util.VendorMobility;
import com.careerdevs.Peddler.util.VendorVendibles;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class VendorModel {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "Vendor_Name", nullable = false, unique = true)
    private String vendorName;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Description")
    private String description;

    @Column(name = "isOpened", nullable = false)
    private boolean openClosed;

    private VendorVendibles Vending;

    private VendorMobility Mobility;

    private List<VendibleModel> Inventory;

    private List<SpaceTimeModel> SpaceTimeList;

    private Double log;

    private Double lat;


    public VendorModel() {
    }


    public void setLocation(double lat, double log) {
        this.lat = lat;
        this.log = log;
    }

    public Location getLocation() {
        return new Location ( lat, log );
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VendorVendibles getVending() {
        return Vending;
    }

    public void setVending(VendorVendibles vending) {
        Vending = vending;
    }

    public VendorMobility getMobility() {
        return Mobility;
    }

    public void setMobility(VendorMobility mobility) {
        Mobility = mobility;
    }

    public boolean isOpenClosed() {
        return openClosed;
    }

    public void setOpenClosed(boolean openClosed) {
        this.openClosed = openClosed;
    }

    public List<VendibleModel> getInventory() {
        return Inventory;
    }

    public List<SpaceTimeModel> getSpaceTimeList() {
        return SpaceTimeList;
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
