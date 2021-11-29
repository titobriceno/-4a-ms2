package com.CitasMs.CitasMs.repositories;

import com.CitasMs.CitasMs.models.Citas;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CitasRepository extends MongoRepository<Citas, String> {

}
