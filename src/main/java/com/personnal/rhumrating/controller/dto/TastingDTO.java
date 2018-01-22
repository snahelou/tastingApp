package com.personnal.rhumrating.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import java.io.Serializable;

@Data
@Wither
@AllArgsConstructor
@NoArgsConstructor
public class TastingDTO implements Serializable{

    private String name;
    private String country;
    private String type;

}
