package com.example.film.domain.valueobects;

import com.example.sharedkernel.domain.base.ValueObject;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Kvalitet implements ValueObject {
    private final int kvalitet;
    protected Kvalitet(){
        this.kvalitet=0;
    }
}
