package com.personnal.rhumrating.controller;

import com.personnal.rhumrating.controller.converter.TastingDTOConverter;
import com.personnal.rhumrating.controller.dto.TastingDTO;
import com.personnal.rhumrating.data.entity.TastingEntity;
import com.personnal.rhumrating.error.InvalidSearchException;
import com.personnal.rhumrating.service.TastingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Api(   value = "Tasting API",
        produces = "application/json",
        tags= {"API"})
@RestController
public class TastingController {
    public static final String TASTING_URL = "/tastings";
    public static final String TASTING_BY_ID_URL = TASTING_URL + "/{id}";

    @Autowired
    private TastingService service;


    @ApiOperation(value = "Create a tasting.")
    @RequestMapping(method = RequestMethod.POST, value = TASTING_URL,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TastingDTO request){
        TastingEntity entity = TastingDTOConverter.toEntity(request);
        service.create(entity);
    }

    @ApiOperation(value = "Read a tasting.")
    @RequestMapping(method = RequestMethod.GET, value = TASTING_BY_ID_URL,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TastingDTO read(@PathVariable("id") UUID id){

        Optional<TastingEntity> result = service.read(id);
        if(result.isPresent()){
            return  TastingDTOConverter.toDTO(result.get());
        }else{
            throw new InvalidSearchException("Tasting not found!");
        }
    }

    @ApiOperation(value = "Udate a tasting.")
    @RequestMapping(method = RequestMethod.PUT, value = TASTING_BY_ID_URL,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.CREATED)
    public TastingDTO fullUpdate(@PathVariable("id")UUID id,
                             @RequestBody TastingDTO request){

        TastingEntity entity = TastingDTOConverter.toEntity(request);
        Optional<TastingEntity> result = service.update(id, entity);
        if(result.isPresent()){
            return TastingDTOConverter.toDTO(result.get());
        }else{
            throw new InvalidSearchException("Tasting not found!");
        }
    }

    @ApiOperation(value = "Deletes a Tasting by ID.")
    @RequestMapping(method = RequestMethod.DELETE, value = TASTING_BY_ID_URL)
    @ResponseBody
    public void deleteById(@PathVariable("id") UUID id) {
        service.delete(id);
    }

    @ApiOperation(value = "Deletes all books.")
    @RequestMapping(method = RequestMethod.DELETE, value = TASTING_URL)
    @ResponseBody
    public void deleteAll() {
        service.deleteAll();
    }

    @ApiOperation(value = "Read all tasting.")
    @RequestMapping(method = RequestMethod.GET, value = TASTING_URL,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TastingDTO> read(){
        String email = ((Map<String,String>)((OAuth2Authentication)SecurityContextHolder.getContext().getAuthentication()).getUserAuthentication().getDetails()).get("email");

        return TastingDTOConverter.toDTOList(service.readAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String ping(){
        return "pong";
    }
}
