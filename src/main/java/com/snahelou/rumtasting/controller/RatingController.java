package com.snahelou.rumtasting.controller;

import com.snahelou.rumtasting.controller.converter.RatingDTOConverter;
import com.snahelou.rumtasting.controller.dto.RatingDTO;
import com.snahelou.rumtasting.service.RatingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(   value = "Rating API",
        produces = "application/json",
        tags= {"Rating"})
@RestController
public class RatingController {

    public static final String RATING_URL = "/ratings";
    public static final String TASTING_BY_ID_URL = RATING_URL + "/{id}";

    @Autowired
    private RatingService service;

    @ApiOperation(value = "Read all ratings.")
    @RequestMapping(method = RequestMethod.GET, value = RATING_URL,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<RatingDTO> read(){
        return RatingDTOConverter.toDTOList(service.getAllRatings());
    }

}
