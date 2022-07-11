package com.careerdevs.Peddler.repositories;

import com.careerdevs.Peddler.models.UserModel;
import com.careerdevs.Peddler.models.VendorModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface VendorRepo extends CrudRepository<VendorModel, UUID> {
    public Optional<VendorModel> findByName (String name);
}
