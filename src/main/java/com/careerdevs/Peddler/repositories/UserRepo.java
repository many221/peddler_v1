package com.careerdevs.Peddler.repositories;

import com.careerdevs.Peddler.models.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends CrudRepository<UserModel, UUID> {

    public Optional<UserModel> findByUserName (String name);
}
