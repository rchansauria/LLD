package com.project.bookmyshow.bookmyshow.models;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Payments extends BaseModel{

    private Double amount;

    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    private String referenceNumber;
}
