package com.project.bookmyshow.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class Theatres extends BaseModel {
    private String theatre_name;
    private String theatre_address;
    private String theatre_city;
    private String theatre_state;
    private String theatre_country;

    @OneToMany
    private List<Screens> screensList;
}
