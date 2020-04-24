package com.myentry.MyEntry.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static com.myentry.MyEntry.constants.CommonConstants.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = IMAGE_TABLE)
public class Image {
    @Id
    private Long id;

    @Column(name = IMAGE_VALUE)
    private String imageValue;

    @OneToOne
    @JoinColumn(name = IMAGE_ID)
    @MapsId
    private Visitor visitor;
}
