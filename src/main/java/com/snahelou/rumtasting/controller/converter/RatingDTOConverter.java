package com.snahelou.rumtasting.controller.converter;

import com.snahelou.rumtasting.controller.dto.AromaRateDTO;
import com.snahelou.rumtasting.controller.dto.RatingDTO;
import com.snahelou.rumtasting.data.entity.RatingEntity;
import lombok.experimental.UtilityClass;

import java.util.*;
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
                .withMark(e.getMark());
    }

    public static List<RatingDTO> toDTOList(List<RatingEntity> list){
        Map<UUID, List<AromaRateDTO>> map = new HashMap<>();
        for (RatingEntity r: list) {
            AromaRateDTO aromaRateDTO = AromaRateDTOConverter.toDTO(r.getAroma(), r.getAromaMark());
            UUID key = r.getRum().getId();
            boolean isPresent = map.containsKey(key);
            if(isPresent){
                map.get(key).add(aromaRateDTO);
            }else{
                List<AromaRateDTO> valueList = new ArrayList<>();
                valueList.add(aromaRateDTO);
                map.put(r.getRum().getId(), valueList);
            }
        }

        return new ArrayList<>(list.stream().map(t -> {
            RatingDTO ratingDTO = toDTO(t);
            ratingDTO.setNoseAroma(map.get(t.getRum().getId()));
            return ratingDTO;
        }).collect(Collectors.toSet()));
    }
}
