package com.careerdevs.Peddler.controllers;

import com.careerdevs.Peddler.models.VendorModel;
import com.careerdevs.Peddler.repositories.VendorRepo;
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
    private VendorRepo vendorRepo;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody VendorModel newVendor){

        try {

            return new ResponseEntity<> ( vendorRepo.save ( newVendor), HttpStatus.CREATED);

        } catch (Exception e){

            return ApiError.genericApiError ( e );
        }

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getByUUID (@PathVariable UUID id){

        try {

            return new ResponseEntity<> ( vendorRepo.findById ( id ),HttpStatus.OK );

        }catch (Exception e){

            return ApiError.genericApiError ( e );

        }
    }

    @GetMapping("/userName/{name}")
    public ResponseEntity<?> getByUserName (@PathVariable String vendorName){

        try {

            return new ResponseEntity<> ( vendorRepo.findByName ( vendorName ),HttpStatus.OK );

        }catch (Exception e){

            return ApiError.genericApiError ( e );

        }

    }


    @PutMapping("/id/{id}")
    public ResponseEntity<?> updateById (@PathVariable UUID id, @RequestBody VendorModel updatedVendor){

        try{

           VendorModel vendor = vendorRepo.findById ( id ).orElseThrow (() -> new ResponseStatusException ( HttpStatus.NOT_FOUND ));

            if (updatedVendor.getVendorName () != null) {
                vendor.setVendorName ( updatedVendor.getVendorName () );
            }
            if (updatedVendor.isOpenClosed () != updatedVendor.isOpenClosed () ) {
                vendor.setOpenClosed ( updatedVendor.isOpenClosed () );
            }

            vendorRepo.save ( vendor );

            return new ResponseEntity<> ( vendor, HttpStatus.OK );

        }catch (Exception e){

            return ApiError.genericApiError ( e );
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteUserById (@PathVariable UUID id) {

        try {

            VendorModel vendor = vendorRepo.findById ( id ).orElseThrow ( () -> new ResponseStatusException ( HttpStatus.NOT_FOUND ) );

            vendorRepo.deleteById ( id );

            return new ResponseEntity<> ( "Vendor: " + vendor.getVendorName () + " has been deleted", HttpStatus.OK );

        } catch (Exception e) {

            return ApiError.genericApiError ( e );

        }
    }
}
