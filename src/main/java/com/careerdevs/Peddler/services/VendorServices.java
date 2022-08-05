package com.careerdevs.Peddler.services;

import com.careerdevs.Peddler.models.VendorModel;
import com.careerdevs.Peddler.repositories.VendorRepo;
import com.careerdevs.Peddler.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VendorServices {

    @Autowired
    VendorRepo repo;

    //CRUD

    public void  saveVendor(VendorModel vendor){

        repo.save ( vendor );

    }

    public VendorModel getById (Long id){

        return repo.findById ( id ).orElseThrow (() -> new ResponseStatusException ( HttpStatus.NOT_FOUND ) );

    }

    public void deleteById (Long id){

        repo.deleteById (id);

    }


    public void setLocation( Long id,Double lat, Double log){

        VendorModel vendor = getById ( id );

//        if (password.matches ( vendor.getPassword () )){

            vendor.setLocation (lat,log);

//        }

    }

    public List<VendorModel> getAllVendors (){

        List<VendorModel> list = new ArrayList<> ();

        repo.findAll ().forEach ( list::add);

        return list;

    }

    public List<VendorModel> getVendorsWithinArea (Double lat, Double log){

        Location location = new Location ( lat,log );

        List<VendorModel> closestVendors = new ArrayList<> ();

        getAllVendors ().stream ().forEach ( v -> {

            Location vLocation = new Location (v.getLat (), v.getLog () );

                    if (location.distanceTo ( vLocation )  <= 1)
                        closestVendors.add ( v );

                }
        );

        return closestVendors;

    }

    public List<VendorModel> getVendorsWithinSpecificArea (Double lat, Double log, Integer area){

        Location location = new Location ( lat,log );

        List<VendorModel> closestVendors = new ArrayList<> ();

        getAllVendors ().stream ().forEach ( v -> {

            Location vLocation = new Location (v.getLat (), v.getLog () );

            if (location.distanceTo ( vLocation )  <= area)
                closestVendors.add ( v );

                }
        );
        return closestVendors;

    }
//    public void openClose(String email, String password, Boolean isOpen){
//
//        VendorModel vendor = repo.findByEmail ( email ).orElseThrow (() -> new ResponseStatusException ( HttpStatus.NOT_FOUND ));
//
//        if (password.matches ( vendor.getPassword () )){
//
//            vendor.setOpenClosed ( isOpen );
//
//        }
//
//    }


//    public List<?> getInventory (String email, String password){
//
//        VendorModel vendor = repo.findByEmail ( email ).orElseThrow (() -> new ResponseStatusException ( HttpStatus.NOT_FOUND ));
//
//        if (password.matches ( vendor.getPassword () )){
//
//            return vendor.getInventory ();
//
//        }
//
//        return null;
//
//    }

//    public List<?>  getSpaceTimeList(String email, String password){
//        VendorModel vendor = repo.findByEmail ( email ).orElseThrow (() -> new ResponseStatusException ( HttpStatus.NOT_FOUND ));
//
//        if (password.matches ( vendor.getPassword () )){
//
//            return vendor.getSpaceTimeList ();
//
//        }
//
//        return null;
//    }

//    public VendibleModel getVendible (String email, String password, UUID vendibleId){
//
//        VendorModel vendor = repo.findByEmail ( email ).orElseThrow (() -> new ResponseStatusException ( HttpStatus.NOT_FOUND ));
//
//        if (password.matches ( vendor.getPassword () )){
//
//            vendor.getInventory ().f
//
//        }
//
//        return null;
//
//    }


}
