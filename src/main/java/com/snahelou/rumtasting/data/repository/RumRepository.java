package com.snahelou.rumtasting.data.repository;


import com.snahelou.rumtasting.data.entity.RumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RumRepository extends JpaRepository<RumEntity,UUID> {

    @Query(value = "SELECT t FROM RumEntity t")
    List<RumEntity> findAllRum();
}
