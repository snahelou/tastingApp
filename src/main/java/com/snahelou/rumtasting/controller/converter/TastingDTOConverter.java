package com.snahelou.rumtasting.controller.converter;

import com.snahelou.rumtasting.controller.dto.TastingDTO;
import com.snahelou.rumtasting.data.entity.TastingEntity;
import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@UtilityClass
public class TastingDTOConverter {

    public static TastingEntity copyEntity(UUID id, TastingDTO dto){
        return dto == null ? null : new TastingEntity()
                .withId(id)
                .withName(dto.getName())
                .withType(dto.getType())
                .withAge(dto.getAge())
                .withBottled(dto.getBottled())
                .withDistilled(dto.getDistilled())
                .withMark(dto.getMark())
                .withNoiseAroma(dto.getNoiseAroma())
                .withTasteAroma(dto.getTasteAroma())
                .withCountry(dto.getCountry());
    }

    public static TastingEntity toEntity(TastingDTO dto){
        return dto == null ? null : new TastingEntity()
                .withName(dto.getName())
                .withType(dto.getType())
                .withAge(dto.getAge())
                .withBottled(dto.getBottled())
                .withDistilled(dto.getDistilled())
                .withMark(dto.getMark())
                .withNoiseAroma(dto.getNoiseAroma())
                .withTasteAroma(dto.getTasteAroma())
                .withCountry(dto.getCountry());
    }

    public static TastingDTO toDTO(TastingEntity e){
        return e == null ? null : new TastingDTO()
                .withName(e.getName())
                .withType(e.getType())
                .withAge(e.getAge())
                .withBottled(e.getBottled())
                .withDistilled(e.getDistilled())
                .withMark(e.getMark())
                .withNoiseAroma(e.getNoiseAroma())
                .withTasteAroma(e.getTasteAroma())
                .withCountry(e.getCountry());
    }

    public static List<TastingDTO> toDTOList(List<TastingEntity> list){
        return list.isEmpty() ? Collections.emptyList() : list.stream().map(TastingDTOConverter::toDTO).collect(Collectors.toList());
    }
}
