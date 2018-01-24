package com.snahelou.rumtasting.service;

import com.snahelou.rumtasting.data.entity.RatingEntity;
import com.snahelou.rumtasting.data.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class RatingService {

    @Autowired
    private RatingRepository repo;

    public List<RatingEntity> getAllRatings(){
        return new ArrayList<>(repo.findAllRating());
    }

}
