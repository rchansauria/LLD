package com.project.bookmyshow.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Movies extends BaseModel {
    private String movie_title;
    private Double rating;
}
