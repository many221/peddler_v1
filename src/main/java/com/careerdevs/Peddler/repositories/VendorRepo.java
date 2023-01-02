package com.careerdevs.Peddler.repositories;

import com.careerdevs.Peddler.models.VendorModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VendorRepo extends CrudRepository<VendorModel, Long> {

    Optional<VendorModel> findByVendorName(String vendorName);

    List<VendorModel> findByLog(Double log);



//    Optional<VendorModel> findByEmail(String email);


}
