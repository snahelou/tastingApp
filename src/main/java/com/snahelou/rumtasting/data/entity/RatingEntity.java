package com.snahelou.rumtasting.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RATING")
@Wither
@EqualsAndHashCode(of = {"rum"})
public class RatingEntity implements Serializable {

    @Id
    @GenericGenerator(name ="uuid-gen",strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type="pg-uuid")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "rum_id", referencedColumnName = "id")
    private RumEntity rum;

    @ManyToOne
    @JoinColumn(name = "aroma_id", referencedColumnName = "id", insertable = false, updatable = false)
    private AromaEntity aroma;

    @Column(name = "aroma_id")
    private UUID aromaId;

    @Column(name = "aroma_mark")
    private Integer aromaMark;

    @Column
    private Integer mark;

    @Column
    private String comment;

}
