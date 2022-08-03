package com.careerdevs.Peddler.services;

import com.careerdevs.Peddler.models.VendibleModel;
import com.careerdevs.Peddler.models.VendorModel;
import com.careerdevs.Peddler.repositories.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public VendorModel getById (UUID id){

        return repo.findById ( id ).orElseThrow (() -> new ResponseStatusException ( HttpStatus.NOT_FOUND ) );

    }

    public void deleteById (UUID id){

        repo.deleteById (id);

    }


    public void setLocation(String email, String password, Double log, Double lat){

        VendorModel vendor = repo.findByEmail ( email ).orElseThrow (() -> new ResponseStatusException ( HttpStatus.NOT_FOUND ));

        if (password.matches ( vendor.getPassword () )){

            vendor.setLocation (lat,log);

        }

    }

    public void openClose(String email, String password, Boolean isOpen){

        VendorModel vendor = repo.findByEmail ( email ).orElseThrow (() -> new ResponseStatusException ( HttpStatus.NOT_FOUND ));

        if (password.matches ( vendor.getPassword () )){

            vendor.setOpenClosed ( isOpen );

        }

    }


    public List<?> getInventory (String email, String password){

        VendorModel vendor = repo.findByEmail ( email ).orElseThrow (() -> new ResponseStatusException ( HttpStatus.NOT_FOUND ));

        if (password.matches ( vendor.getPassword () )){

            return vendor.getInventory ();

        }

        return null;

    }

    public List<?>  getSpaceTimeList(String email, String password){
        VendorModel vendor = repo.findByEmail ( email ).orElseThrow (() -> new ResponseStatusException ( HttpStatus.NOT_FOUND ));

        if (password.matches ( vendor.getPassword () )){

            return vendor.getSpaceTimeList ();

        }

        return null;
    }

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
