package com.project.bookmyshow.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Shows extends BaseModel {

    @ManyToOne
    private Movies movie;
    private Date start_time;
    private Date end_time;

    @ManyToOne
    private Screens screens;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Features> featuresList;


}
