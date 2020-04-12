package com.myentry.MyEntry.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

/**
 * Author :SAURAV ROY
 */
@Entity
@Table(name = "laptopRequest")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EscortManager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(name="office_location")
    private Locations locations;


}
