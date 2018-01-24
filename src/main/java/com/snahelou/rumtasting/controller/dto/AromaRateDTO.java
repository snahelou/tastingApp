package com.snahelou.rumtasting.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import java.io.Serializable;

@Data
@Wither
@AllArgsConstructor
@NoArgsConstructor
public class AromaRateDTO implements Serializable {

    // Rate multiple aroma with integer... (nose and mouth)
    // { Vegetal: 5, Sugar: 3, Fruit:4 }
    private String aroma;
    private Integer rate;

}
