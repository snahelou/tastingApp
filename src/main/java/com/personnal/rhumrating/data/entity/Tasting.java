package com.personnal.rhumrating.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tasting {

    private UUID id;
    private String name;
    private String country;
    private String type;

}
