package com.snahelou.rumtasting.controller.dto;

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
public class RatingDTO implements Serializable{

    private RumDTO rum;

    private Integer mark;

    private String comment;

    private AromaRateDTO noseAroma;

    private List<AromaRateDTO> tasteAroma;
}
