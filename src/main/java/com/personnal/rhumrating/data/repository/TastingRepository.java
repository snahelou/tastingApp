package com.personnal.rhumrating.data.repository;


import com.personnal.rhumrating.data.entity.TastingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface TastingRepository extends JpaRepository<TastingEntity,UUID> {

    @Query(value = "SELECT t FROM TastingEntity t")
    List<TastingEntity> findAll();
}
