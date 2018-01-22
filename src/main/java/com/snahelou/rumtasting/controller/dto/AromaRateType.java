package com.snahelou.rumtasting.controller.dto;

import com.snahelou.rumtasting.controller.dto.enums.AromaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import java.util.Map;

@Data
@Wither
@AllArgsConstructor
@NoArgsConstructor
public class AromaRateType {

    // Rate multiple aroma with integer... (nose and mouth)
    // { Vegetal: 5, Sugar: 3, Fruit:4 }
    private Map<AromaEnum,Integer> noiseAroma;

}
