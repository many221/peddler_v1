package com.careerdevs.Peddler.services;

import com.careerdevs.Peddler.models.UserModel;
import com.careerdevs.Peddler.models.VendorModel;
import com.careerdevs.Peddler.repositories.UserRepo;
import com.careerdevs.Peddler.repositories.VendorRepo;
import com.careerdevs.Peddler.util.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.*;

@Service
public class UserServices {

    //O> Convert list of vendor IDs to vendors

    @Autowired
    UserRepo userRepo;

    @Autowired
    VendorRepo vendorRepo;
    private Iterable<VendorModel> vendors;

    public void saveUserToRepo (UserModel user){

        userRepo.save ( user );

    }

    public UserModel getUserByID (UUID uuid){

        return userRepo.findById ( uuid ).orElseThrow (() -> new ResponseStatusException ( HttpStatus.NOT_FOUND ) );

    }


    public void deleteUserById (UUID uuid){

        userRepo.deleteById ( uuid );

    }

    public List<VendorModel> getVendorsWithinArea (Double log, Double lat){

        Location userLocation = new Location ( lat,log );

        List<VendorModel> closestVendors = new ArrayList<> ();

       Iterator<VendorModel> it = vendorRepo.findAll ().iterator ();

       while(it.hasNext ()){

          Location vendorLocation = it.next ().getLocation ();

          if (userLocation.distanceTo ( vendorLocation ) <= 1)
              closestVendors.add ( it.next () );

       }

       return closestVendors;

    }

    public List<VendorModel> getVendorsWithinSpecificArea (Double log, Double lat, Integer area){

        Location userLocation = new Location ( lat,log );

        List<VendorModel> closestVendors = new ArrayList<> ();

        Iterator<VendorModel> it = vendorRepo.findAll ().iterator ();

        while(it.hasNext ()){

            Location vendorLocation = it.next ().getLocation ();

            if (userLocation.distanceTo ( vendorLocation ) <= area)
                closestVendors.add ( it.next () );

        }

        return closestVendors;

    }

    public void userCheckInAtVendor (UUID uuid, UUID vendorId, String password){

        UserModel user = userRepo.findById ( uuid ).orElseThrow (() -> new ResponseStatusException ( HttpStatus.NOT_FOUND ) );

        if (user.getPassword ().equals ( password )) {

            Timestamp timestamp = new Timestamp ( System.currentTimeMillis () );

            user.checkInAtVendor ( timestamp, vendorId  );

        }
    }

    public Map getVendorHistory(UUID uuid, String password){

        UserModel user = userRepo.findById ( uuid ).orElseThrow (() -> new ResponseStatusException ( HttpStatus.NOT_FOUND ) );

        if (!user.getPassword ().equals ( password )) {

         return null;

        }

        return user.getVendorHistory ();

    }

    public void clearVendorHistory (UUID uuid, String password){

        UserModel user = userRepo.findById ( uuid ).orElseThrow (() -> new ResponseStatusException ( HttpStatus.NOT_FOUND ) );

        if (user.getPassword ().equals ( password )) {

           user.clearVendorHistory ();

        }
    }
     public List<UUID> getFavoriteVendors (UUID uuid, String password){

        ArrayList<String> favorites = new ArrayList<> ();

        return getUserByID ( uuid ).getFavoriteVendors ().stream().toList ();

     }

    public void addVendorToFavorites (UUID uuid, UUID vendorId, String password){

        UserModel user = userRepo.findById ( uuid ).orElseThrow (() -> new ResponseStatusException ( HttpStatus.NOT_FOUND ) );

        if (user.getPassword ().equals ( password )) {

            user.addFavoriteVendors ( vendorId );

        }

    }

    public void removeVendorToFavorites (UUID uuid, UUID vendorId, String password){

        UserModel user = userRepo.findById ( uuid ).orElseThrow (() -> new ResponseStatusException ( HttpStatus.NOT_FOUND ) );

        if (user.getPassword ().equals ( password )) {

            user.removeFavoriteVendor ( vendorId );

        }

    }

}
