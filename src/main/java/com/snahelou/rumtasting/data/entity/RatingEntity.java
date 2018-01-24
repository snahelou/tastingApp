package com.snahelou.rumtasting.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
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
public class RatingEntity implements Serializable {

    @Id
    @GenericGenerator(name ="uuid-gen",strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type="pg-uuid")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "rum_id", referencedColumnName = "id")
    private RumEntity rum;

//    @OneToMany(targetEntity = AromaEntity.class)
//    @MapKeyJoinColumn(name = "aroma_id")
//    private Map<AromaEntity, Integer> nose;

    @ManyToOne
    @JoinColumn(name = "aroma_id", referencedColumnName = "id")
    private AromaEntity aromaList;

//    @Column(name = "aroma_id")
//    private UUID noseId;

    @Column(name = "aroma_mark")
    private Integer noseMark;

    @Column
    private Integer mark;

    @Column
    private String comment;


}
