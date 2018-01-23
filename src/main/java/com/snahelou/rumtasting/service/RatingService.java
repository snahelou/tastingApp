package com.snahelou.rumtasting.service;

import com.snahelou.rumtasting.data.entity.RatingEntity;
import com.snahelou.rumtasting.data.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RatingService {

    @Autowired
    private RatingRepository repo;

    public List<RatingEntity> getAllRatings(){
        return repo.findAllRating();
    }

}
