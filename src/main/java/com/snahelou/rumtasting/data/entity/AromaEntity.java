package com.snahelou.rumtasting.data.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.snahelou.rumtasting.controller.dto.enums.AromaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
@Table(name = "AROMA")
@Wither
public class AromaEntity implements Serializable {

    @Id
    @GenericGenerator(name ="uuid-gen",strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type="pg-uuid")
    private UUID id;

    @Column
    @Enumerated(EnumType.STRING)
    private AromaEnum name;
}
