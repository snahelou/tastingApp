package com.personnal.rhumrating.controller.converter;

import com.personnal.rhumrating.controller.dto.TastingDTO;
import com.personnal.rhumrating.data.entity.TastingEntity;
import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class TastingDTOConverter {

    public static TastingEntity toEntity(TastingDTO dto){
        return dto == null ? null : new TastingEntity()
                .withName(dto.getName())
                .withType(dto.getType())
                .withCountry(dto.getCountry());
    }

    public static TastingDTO toDTO(TastingEntity e){
        return e == null ? null : new TastingDTO()
                .withName(e.getName())
                .withType(e.getType())
                .withCountry(e.getCountry());
    }

    public static List<TastingDTO> toDTOList(List<TastingEntity> list){
        return list.isEmpty() ? Collections.emptyList() : list.stream().map(TastingDTOConverter::toDTO).collect(Collectors.toList());
    }
}
