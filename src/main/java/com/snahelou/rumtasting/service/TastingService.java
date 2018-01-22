package com.snahelou.rumtasting.service;

import com.snahelou.rumtasting.controller.dto.TastingDTO;
import com.snahelou.rumtasting.data.entity.TastingEntity;
import com.snahelou.rumtasting.data.repository.TastingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class TastingService {

    @Autowired
    private TastingRepository repo;

    @Autowired
    public TastingService (TastingRepository repo){
        this.repo = repo;
    }

    public TastingEntity create (TastingEntity e){
//        validate(e);
        return repo.save(e);
    }

    public Optional<TastingEntity> read (UUID id){
        return Optional.of(repo.findOne(id));
    }

    public List<TastingEntity> readAll(){
        return repo.findAll();
    }

    @Transactional
    public Optional<TastingEntity> update(UUID id, TastingEntity request){
        Optional<TastingEntity> entity = read(id);
        if (entity.isPresent()){
//            validate(request);
            return Optional.of(repo.save(request));
        }
        return Optional.empty();
    }

    public void delete(UUID id) {
        repo.delete(id);
    }

    public void deleteAll() {
        repo.deleteAll();
    }

//TODO in bean with @Validate
    private void validate(TastingDTO request) {
        Assert.notNull(request.getName(), "Name can't be null!");
        Assert.notNull(request.getCountry(), "Country can't be null!");
        Assert.notNull(request.getType(), "Type can't be null!");
    }
}
