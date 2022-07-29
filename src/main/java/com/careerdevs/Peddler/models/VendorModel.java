package com.careerdevs.Peddler.models;

import com.careerdevs.Peddler.util.Location;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class VendorModel {

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false, unique = true)
    private UUID id;

    @Column(name = "Vendor_Name", nullable = false, unique = true)
    private String vendorName;

    private Double log;

    private Double lat;

//I Time Stamp

//    @Column(name = "Vendor_Location")
//    private Location location;

    //O Menu/Inventory datatype

    //O Schedule  datatype

    //O Wares datatype

    @Column(name = "isOpened", nullable = false)
    private boolean openClosed;

    public VendorModel() {
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

//    public Location getLocation() {
//        return location;
//    }
//
//    public void setLocation(Location location) {
//        this.location = location;
//    }

    public void setLocation(double lat, double log){
        this.lat = lat;
        this.log = log;
    }
    
    public Location getLocation(){
        return new Location ( lat,log );
    }

    public boolean isOpenClosed() {
        return openClosed;
    }

    public void setOpenClosed(boolean openClosed) {
        this.openClosed = openClosed;
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
