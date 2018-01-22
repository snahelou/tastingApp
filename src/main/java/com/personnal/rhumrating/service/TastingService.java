package com.personnal.rhumrating.service;

import com.personnal.rhumrating.data.entity.Tasting;
import com.personnal.rhumrating.data.entity.TastingEntity;
import com.personnal.rhumrating.data.entity.TastingRequest;
import com.personnal.rhumrating.data.repository.TastingRepository;
import com.personnal.rhumrating.error.InvalidSearchException;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class TastingService {

    @Autowired
    private TastingRepository repo;

    private Mapper mapper;

    @Autowired
    public TastingService (TastingRepository repo, Mapper mapper){
        this.repo = repo;
        this.mapper = mapper;
    }

    public Tasting create (TastingRequest request){
        validate(request);
        TastingEntity entity = mapper.map(request,TastingEntity.class);
        entity = repo.save(entity);
        Tasting t = mapper.map(entity,Tasting.class);
        return t;
    }

    public Tasting read (UUID id){
        TastingEntity entity = repo.findOne(id);
        return map(entity);
    }

    public List<Tasting> readAll(){
        return map(repo.findAll());
    }

    @Transactional
    public Tasting update(UUID id, TastingRequest request){
        TastingEntity entity = repo.findOne(id);
        if (entity == null){
            throw new InvalidSearchException("Tasting not found!");
        }
        validate(request);
        mapper.map(request,entity);
        entity = repo.save(entity);

        Tasting tasting = mapper.map(entity,Tasting.class);
        return tasting;
    }



    public void delete(UUID id) {
        repo.delete(id);
    }

    public void deleteAll() {
        repo.deleteAll();
    }

    private Tasting map(TastingEntity entity){
        if (entity == null){
            throw new InvalidSearchException("Tasting not found!");
        }
        return mapper.map(entity,Tasting.class);
    }

    private List<Tasting> map(List<TastingEntity> entities ){
        if (entities == null){
            throw new InvalidSearchException("Tasting not found!");
        }
        return entities.stream().map(
                r -> mapper.map(r,Tasting.class)).collect(
                        Collectors.toList());
    }

    private void validate(TastingRequest request) {
        Assert.notNull(request.getName(), "Name can't be null!");
        Assert.notNull(request.getCountry(), "Country can't be null!");
        Assert.notNull(request.getType(), "Type can't be null!");
    }
}
