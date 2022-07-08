package com.careerdevs.Peddler.repositories;

import com.careerdevs.Peddler.models.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepo extends CrudRepository<UserModel, UUID> {
}
