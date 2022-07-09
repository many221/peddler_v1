package com.careerdevs.Peddler.controllers;

import com.careerdevs.Peddler.models.UserModel;
import com.careerdevs.Peddler.repositories.UserRepo;
import com.careerdevs.Peddler.util.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {


    //Create Read Update Delete

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserModel newUser){

        try {

            return new ResponseEntity<> ( userRepo.save ( newUser), HttpStatus.CREATED);

        } catch (Exception e){

            return ApiError.genericApiError ( e );
        }

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getByUUID (@PathVariable UUID id){

        try {

            return new ResponseEntity<> ( userRepo.findById ( id ),HttpStatus.OK );

        }catch (Exception e){

            return ApiError.genericApiError ( e );

        }
    }

    @GetMapping("/userName/{name}")
    public ResponseEntity<?> getByUserName (@PathVariable String userName){

        try {

            return new ResponseEntity<> ( userRepo.findByUserName ( userName ),HttpStatus.OK );

        }catch (Exception e){

            return ApiError.genericApiError ( e );

        }

    }


    @PutMapping("/id/{id}")
    public ResponseEntity<?> updateById (@PathVariable UUID id, @RequestBody UserModel updatedUser){

        try{

            UserModel user = userRepo.findById ( id ).orElseThrow (() -> new ResponseStatusException ( HttpStatus.NOT_FOUND ));

            if (updatedUser.getUserName () != null) {
                user.setUserName ( updatedUser.getUserName () );
            }
            if (updatedUser.getAge () != 0) {
                user.setAge ( updatedUser.getAge () );
            }
            if (updatedUser.getGender () != null) {
                user.setGender ( updatedUser.getGender () );
            }

            userRepo.save ( user );

            return new ResponseEntity<> ( user, HttpStatus.OK );

        }catch (Exception e){

            return ApiError.genericApiError ( e );
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteUserById (@PathVariable UUID id) {

        try {

            UserModel user = userRepo.findById ( id ).orElseThrow ( () -> new ResponseStatusException ( HttpStatus.NOT_FOUND ) );

            userRepo.deleteById ( id );

            return new ResponseEntity<> ( "User: " + user.getUserName () + " has been deleted", HttpStatus.OK );

        } catch (Exception e) {

            return ApiError.genericApiError ( e );

        }
    }

}
