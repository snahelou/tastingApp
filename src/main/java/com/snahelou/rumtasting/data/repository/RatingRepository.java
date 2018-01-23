package com.snahelou.rumtasting.data.repository;


import com.snahelou.rumtasting.data.entity.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RatingRepository extends JpaRepository<RatingEntity,UUID> {

    @Query(value = "SELECT t FROM RatingEntity t")
    List<RatingEntity> findAllRating();
}
