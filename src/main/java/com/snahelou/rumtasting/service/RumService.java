package com.snahelou.rumtasting.service;

import com.snahelou.rumtasting.controller.dto.RumDTO;
import com.snahelou.rumtasting.data.entity.RumEntity;
import com.snahelou.rumtasting.data.repository.RumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class RumService {

    @Autowired
    private RumRepository repo;

    @Autowired
    public RumService(RumRepository repo){
        this.repo = repo;
    }

    public RumEntity create (RumEntity e){
//        validate(e);
        return repo.save(e);
    }

    public Optional<RumEntity> read (UUID id){
        return Optional.of(repo.findOne(id));
    }

    public List<RumEntity> readAll(){
        return repo.findAllRum();
    }

    @Transactional
    public Optional<RumEntity> update(UUID id, RumEntity request){
        Optional<RumEntity> entity = read(id);
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
    private void validate(RumDTO request) {
        Assert.notNull(request.getName(), "Name can't be null!");
        Assert.notNull(request.getCountry(), "Country can't be null!");
        Assert.notNull(request.getType(), "Type can't be null!");
    }
}
