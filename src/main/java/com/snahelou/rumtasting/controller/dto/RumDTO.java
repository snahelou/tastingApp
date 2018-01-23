package com.snahelou.rumtasting.controller.dto;

import com.snahelou.rumtasting.controller.dto.enums.TypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import java.io.Serializable;
import java.util.List;

@Data
@Wither
@AllArgsConstructor
@NoArgsConstructor
public class RumDTO implements Serializable{

    private String name;
    private String country;
    private TypeEnum type;
    private Integer distilled;
    private Integer bottled;
    private Integer mark;
    private Integer age;
    private List<AromaRate> noiseAroma;
    private List<AromaRate> tasteAroma;

}
