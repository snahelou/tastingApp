package com.personnal.rhumrating.controller;

import com.personnal.rhumrating.data.entity.Tasting;
import com.personnal.rhumrating.data.entity.TastingRequest;
import com.personnal.rhumrating.service.TastingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api(   value = "Tasting API",
        description = "Tasting API",
        produces = "application/json",
        tags= {"API"})
@RestController
public class TastingController {
    public static final String TASTING_URL = "/tastings";
    public static final String TASTING_BY_ID_URL = TASTING_URL + "/{id}";

    @Autowired
    private TastingService service;

    @ApiOperation(
            value = "Create a tasting.",
            response = Tasting.class)
    @ApiResponses(
            @ApiResponse(code = 201, response = Override.class,
                         message = "Override created successfully"))
    @RequestMapping(method = RequestMethod.POST, value = TASTING_URL,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Tasting create(@RequestBody TastingRequest request){
        return service.create(request);
    }

    @ApiOperation(
            value = "Read a tasting.",
            response = Tasting.class)
    @RequestMapping(method = RequestMethod.GET, value = TASTING_BY_ID_URL,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Tasting read(@PathVariable("id") UUID id){
        return service.read(id);
    }

    @ApiOperation(
            value = "Udate a tasting.",
            response = Tasting.class)
    @ApiResponses(
            @ApiResponse(code = 201, response = Tasting.class,
                    message = "Updated book successfully"))
    @RequestMapping(method = RequestMethod.PUT, value = TASTING_BY_ID_URL,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Tasting update(@PathVariable("id")UUID id, @RequestBody TastingRequest request){
        return service.update(id,request);
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

    @ApiOperation(
            value = "Read all tasting.",
            response = Tasting.class)
    @RequestMapping(method = RequestMethod.GET, value = TASTING_URL,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Tasting> read(){
        return service.readAll();
    }

}
