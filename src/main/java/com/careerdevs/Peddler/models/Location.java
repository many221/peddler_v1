package com.careerdevs.Peddler.models;

import com.careerdevs.Peddler.repositories.VendorRepo;
import com.careerdevs.Peddler.services.VendorServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Location {

    @Autowired
    VendorRepo repo;

    //X This code is based off of this https://introcs.cs.princeton.edu/java/44st/Location.java.html
    private double longitude;
    private double latitude;

    // create and initialize a point with given name and
    // (latitude, longitude) specified in degrees
    public Location( double latitude, double longitude) {
        this.latitude  = latitude;
        this.longitude = longitude;
    }

    // return distance between this location and that location
    // measured in statute miles
    public double distanceTo(Location that) {
        double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lat2 = Math.toRadians(that.latitude);
        double lon2 = Math.toRadians(that.longitude);

        // great circle distance in radians, using law of cosines formula
        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

        // each degree on a great circle of Earth is 60 nautical miles
        double nauticalMiles = 60 * Math.toDegrees(angle);
        double statuteMiles = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
        return statuteMiles;
    }

    // return string representation of this point
    public String toString() {
        return " (" + latitude + ", " + longitude + ")";
    }





    public static void main(String[] args) {
//        Location here = new Location (  );
        VendorServices services = new VendorServices();
        System.out.println (services.getAllVendors ());


    }

}
