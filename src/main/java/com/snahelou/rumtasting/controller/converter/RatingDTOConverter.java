package com.snahelou.rumtasting.controller.converter;

import com.snahelou.rumtasting.controller.dto.RatingDTO;
import com.snahelou.rumtasting.data.entity.RatingEntity;
import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@UtilityClass
public class RatingDTOConverter {

    public static RatingEntity copyEntity(UUID id, RatingDTO dto){
        return dto == null ? null : new RatingEntity()
                .withId(id)
                .withComment(dto.getComment())
                .withMark(dto.getMark());
    }


    public static RatingDTO toDTO(RatingEntity e){
        return e == null ? null : new RatingDTO()
                .withComment(e.getComment())
                .withMark(e.getMark())
                .withRum(RumDTOConverter.toDTO(e.getRum()))
                .withNoseAroma(AromaRateDTOConverter.toDTO(e.getAromaList(), e.getNoseMark()));
    }

    public static List<RatingDTO> toDTOList(List<RatingEntity> list){
        return list.isEmpty() ? Collections.emptyList() : list.stream().map(RatingDTOConverter::toDTO).collect(Collectors.toList());
    }
}
