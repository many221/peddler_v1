package com.careerdevs.Peddler.controllers;

import com.careerdevs.Peddler.models.UserModel;

import com.careerdevs.Peddler.services.UserServices;
import com.careerdevs.Peddler.util.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {




    @Autowired
    private UserServices services;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserModel newUser){

        try {

            services.saveUserToRepo ( newUser );

            return ResponseEntity.ok ( newUser );

        } catch (Exception e){

            return ApiError.genericApiError ( e );
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByUUID (@PathVariable UUID id){

        try {

            return ResponseEntity.ok (services.getUserByID ( id ));

        }catch (Exception e){

            return ApiError.genericApiError ( e );

        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateById (@PathVariable UUID id, @RequestBody UserModel updatedUser){

        try{

            UserModel user = services.getUserByID ( id );

            if (updatedUser.getUserName () != null) {
                user.setUserName ( updatedUser.getUserName () );
            }
            if(updatedUser.getPassword () != null){
                user.setPassword ( updatedUser.getPassword () );
            }
            if (updatedUser.getAge () != 0) {
                user.setAge ( updatedUser.getAge () );
            }
            if (updatedUser.getGender () != null) {
                user.setGender ( updatedUser.getGender () );
            }

            services.saveUserToRepo ( user );

            return ResponseEntity.ok (user);

        }catch (Exception e){

            return ApiError.genericApiError ( e );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById (@PathVariable UUID id) {

        try {

            UserModel user = services.getUserByID ( id );

            services.deleteUserById ( id );

            return ResponseEntity.ok ("User: " + user.getUserName () + " has been deleted");

        } catch (Exception e) {

            return ApiError.genericApiError ( e );

        }
    }

//    @GetMapping("/vendors")
//    public ResponseEntity<?> getVendorsInArea(@RequestParam List<Double> coordinates){
//
//        try {
//
//            return ResponseEntity.ok (services.getVendorsWithinArea ( coordinates.get ( 0 ),coordinates.get ( 1 ) ));
//
//        } catch (Exception e){
//
//            return ApiError.genericApiError ( e );
//
//        }
//
//    }
//
//    @GetMapping("/vendors/area/{area}")
//    public ResponseEntity<?> getVendorsInSpecificArea(@PathVariable Integer area ,@RequestParam List<Double> coordinates){
//
//        try {
//
//            return ResponseEntity.ok (services.getVendorsWithinSpecificArea ( coordinates.get ( 0 ) ,coordinates.get ( 1 ) ,area ));
//
//        } catch (Exception e){
//
//            return ApiError.genericApiError ( e );
//
//        }
//
//    }

    //O> Change id to username
   // @GetMapping("{id}/vendors/favorite")
//    public ResponseEntity<?> getFavoriteVendors(@PathVariable UUID id, @RequestParam String password){
//
//        try {
//
//            return ResponseEntity.ok (services.getFavoriteVendors ( id, password ));
//
//        } catch (Exception e){
//
//            return ApiError.genericApiError ( e );
//
//        }
//
//    }


//    @PatchMapping("{id}/vendors/favorite/add/{vendorId}")
//    public ResponseEntity<?> addFavoriteVendors(@PathVariable UUID id,@PathVariable UUID vendorId, @RequestParam String password){
//
//        try {
//
//            services.addVendorToFavorites (id,vendorId,password );
//
//            return new ResponseEntity<> ( HttpStatus.OK );
//
//        } catch (Exception e){
//
//            return ApiError.genericApiError ( e );
//
//        }
//
//    }

//    @DeleteMapping("{id}/vendors/favorite/remove/{vendorId}")
//    public ResponseEntity<?> removeFavoriteVendors(@PathVariable UUID id,@PathVariable UUID vendorId, @RequestParam String password){
//
//        try {
//
//            services.removeVendorToFavorites (id,vendorId,password );
//
//            return new ResponseEntity<> ( HttpStatus.OK );
//
//        } catch (Exception e){
//
//            return ApiError.genericApiError ( e );
//
//        }
//
//    }

//    @PatchMapping("{id}/vendors/checkin/{vendorId}")
//    public ResponseEntity<?> checkInAtVendors(@PathVariable UUID id,@PathVariable UUID vendorId, @RequestParam String password){
//
//        try {
//
//            services.userCheckInAtVendor (id,vendorId,password );
//
//            return new ResponseEntity<> ( HttpStatus.OK );
//
//        } catch (Exception e){
//
//            return ApiError.genericApiError ( e );
//
//        }
//
//    }

//    @PatchMapping("{id}/vendors/checkin/clear")
//    public ResponseEntity<?> clearCheckInHistory(@PathVariable UUID id, @RequestParam String password){
//
//        try {
//
//            services.clearVendorHistory (id,password );
//
//            return new ResponseEntity<> ( HttpStatus.OK );
//
//        } catch (Exception e){
//
//            return ApiError.genericApiError ( e );
//
//        }
//
//    }


}
