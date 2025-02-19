package com.project.bookmyshow.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Cities extends BaseModel {

    private String city_name;
    private List<Theatres> theatresList;

}
