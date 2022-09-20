package com.example.film.domain.models;

import com.example.film.domain.valueobects.Kvalitet;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.financial.Money;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "film_table")
@Getter
public class Film extends AbstractEntity<FilmId> {
    private String filmName;
    //private Kvalitet kvalitet;
    private int numadded=0;
    @AttributeOverrides({@AttributeOverride(name="currency", column = @Column(name = "pricecurrency")),
    @AttributeOverride(name = "amount", column = @Column(name = "priceamount"))})
    private Money price;
    private Film(){
        super(FilmId.randomId(FilmId.class));
    }
    public static Film build(String filmName, Money price, int numadded) {
        Film f = new Film();
        f.filmName = filmName;
        f.price = price;
        f.numadded = numadded;
        return f;
    }
    public void addSales() {
        this.numadded = this.numadded +1;
    }

    public void removeSales() {
        this.numadded = this.numadded +1;
    }


}
