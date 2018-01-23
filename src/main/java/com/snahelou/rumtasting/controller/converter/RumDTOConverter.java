package com.snahelou.rumtasting.controller.converter;

import com.snahelou.rumtasting.controller.dto.RumDTO;
import com.snahelou.rumtasting.data.entity.RumEntity;
import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@UtilityClass
public class RumDTOConverter {

    public static RumEntity copyEntity(UUID id, RumDTO dto){
        return dto == null ? null : new RumEntity()
                .withId(id)
                .withName(dto.getName())
                .withType(dto.getType())
                .withAge(dto.getAge())
                .withBottled(dto.getBottled())
                .withDistilled(dto.getDistilled())
                .withCountry(dto.getCountry());
    }

    public static RumEntity toEntity(RumDTO dto){
        return dto == null ? null : new RumEntity()
                .withName(dto.getName())
                .withType(dto.getType())
                .withAge(dto.getAge())
                .withBottled(dto.getBottled())
                .withDistilled(dto.getDistilled())
                .withCountry(dto.getCountry());
    }

    public static RumDTO toDTO(RumEntity e){
        return e == null ? null : new RumDTO()
                .withName(e.getName())
                .withType(e.getType())
                .withAge(e.getAge())
                .withBottled(e.getBottled())
                .withDistilled(e.getDistilled())
                .withCountry(e.getCountry());
    }

    public static List<RumDTO> toDTOList(List<RumEntity> list){
        return list.isEmpty() ? Collections.emptyList() : list.stream().map(RumDTOConverter::toDTO).collect(Collectors.toList());
    }
}
