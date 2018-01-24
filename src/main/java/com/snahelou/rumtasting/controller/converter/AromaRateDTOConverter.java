package com.snahelou.rumtasting.controller.converter;

import com.snahelou.rumtasting.controller.dto.AromaRateDTO;
import com.snahelou.rumtasting.data.entity.AromaEntity;
import lombok.experimental.UtilityClass;


@UtilityClass
public class AromaRateDTOConverter {

    public static AromaRateDTO toDTO(AromaEntity e, Integer mark){
        return new AromaRateDTO().withAroma(e.getName().getAroma())
                .withRate(mark);
    }

}
