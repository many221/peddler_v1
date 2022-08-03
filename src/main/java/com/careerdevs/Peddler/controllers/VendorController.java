package com.careerdevs.Peddler.controllers;

import com.careerdevs.Peddler.models.VendorModel;
import com.careerdevs.Peddler.repositories.VendorRepo;
import com.careerdevs.Peddler.services.VendorServices;
import com.careerdevs.Peddler.util.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {
    @Autowired
    private VendorServices services;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody VendorModel newVendor){

        try {

            services.saveVendor ( newVendor );

            return new ResponseEntity<> ( newVendor , HttpStatus.CREATED);

        } catch (Exception e){

            return ApiError.genericApiError ( e );
        }

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getByUUID (@PathVariable UUID id){

        try {

            return new ResponseEntity<> ( services.getById ( id ),HttpStatus.OK );

        }catch (Exception e){

            return ApiError.genericApiError ( e );

        }

    }

    @PutMapping("/id/{id}")
    public ResponseEntity<?> updateById (@PathVariable UUID id, @RequestBody VendorModel updatedVendor){

        try{

           VendorModel vendor = services.getById ( id );

            if (updatedVendor.getVendorName () != null) {
                vendor.setVendorName ( updatedVendor.getVendorName () );
            }

            if (updatedVendor.getEmail () != null) {
                vendor.setEmail ( updatedVendor.getVendorName (););
            }

            if (updatedVendor.getPassword () != null) {
                vendor.setPassword ( updatedVendor.getPassword () );
            }

            if (updatedVendor.getDescription () != null) {
                vendor.setDescription ( updatedVendor.getDescription () );
            }

            services.saveVendor ( vendor );

            return new ResponseEntity<> ( vendor, HttpStatus.OK );

        }catch (Exception e){

            return ApiError.genericApiError ( e );
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteUserById (@PathVariable UUID id) {

        try {

            VendorModel vendor = services.getById ( id ) ;

            services.deleteById ( id );

            return new ResponseEntity<> ( "Vendor: " + vendor.getVendorName () + " has been deleted", HttpStatus.OK );

        } catch (Exception e) {

            return ApiError.genericApiError ( e );

        }
    }

    @PatchMapping("/email")
    public ResponseEntity<?> setLocation(@RequestParam String password,)
}
