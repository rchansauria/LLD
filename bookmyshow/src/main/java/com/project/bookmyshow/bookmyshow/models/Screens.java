package com.project.bookmyshow.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
public class Screens extends BaseModel {
    private String screen_name;

    @ManyToOne
    private Theatres theatres;

    @OneToMany
    private List<Seats> seatsList;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Features> featuresList;

    @Enumerated(EnumType.ORDINAL)
    private ScreenStatus screenStatus;

}
