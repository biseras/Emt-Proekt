package com.example.film.services.form;

import com.example.sharedkernel.domain.financial.Money;
import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;

@Data
public class FilmForm {
    private String filmName;
    //private Kvalitet kvalitet;
    private int numadded;
    private Money price;
}
