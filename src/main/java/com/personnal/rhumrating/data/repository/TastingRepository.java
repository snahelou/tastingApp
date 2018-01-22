package com.personnal.rhumrating.data.repository;


import com.personnal.rhumrating.data.entity.Tasting;
import com.personnal.rhumrating.data.entity.TastingEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TastingRepository extends CrudRepository<TastingEntity,UUID>{
    List<TastingEntity> findAll();
}
