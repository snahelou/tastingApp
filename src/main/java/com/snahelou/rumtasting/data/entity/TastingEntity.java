package com.snahelou.rumtasting.data.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.snahelou.rumtasting.controller.dto.AromaRate;
import com.snahelou.rumtasting.controller.dto.AromaRateType;
import com.snahelou.rumtasting.controller.dto.enums.TypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
@Table(name = "tasting")
@Wither
@TypeDef(name = "AromaRateType", typeClass = AromaRateType.class)
public class TastingEntity implements Serializable {
    @Id
    @GenericGenerator(name ="uuid-gen",strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type="pg-uuid")
    private UUID id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "country",nullable = false)
    private String country;

    @Column(name = "type",nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    @Column(name = "distilled")
    private Integer distilled;

    @Column(name = "bottled")
    private Integer bottled;

    @Column(name = "mark",nullable = false)
    private Integer mark;

    @Column(name = "age",nullable = false)
    private Integer age;

    @Column(name = "noise_aroma",nullable = false)
    @Type(type = "com.snahelou.rumtasting.controller.dto.AromaRateType",
            parameters = {@Parameter(name = "className",
                    value = "com.snahelou.rumtasting.controller.dto.AromaRate")})
    private AromaRate noiseAroma;

    @Column(name = "taste_aroma",nullable = false)
    @Type(type = "com.snahelou.rumtasting.controller.dto.AromaRateType",
            parameters = {@Parameter(name = "className",
                    value = "com.snahelou.rumtasting.controller.dto.AromaRate")})
    private AromaRate tasteAroma;

}
