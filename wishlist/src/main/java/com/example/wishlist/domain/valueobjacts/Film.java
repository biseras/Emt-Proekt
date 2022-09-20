package com.example.wishlist.domain.valueobjacts;

import com.example.sharedkernel.domain.base.ValueObject;
import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Film implements ValueObject {
    private final FilmId filmId;
    private final String name;
    private final Money price;
    private final int addednum;

    public Film(String name, Money price, int addednum) {
        this.filmId=FilmId.randomId(FilmId.class);
        this.name = name;
        this.price = price;
        this.addednum = addednum;
    }
    //    private Film(){
//        this.filmId=FilmId.randomId(FilmId.class);
//        this.name="";
//        this.price=Money.valueOf(Currency.EUR, 0);
//        this.addednum=0;
//    }

    @JsonCreator
    public Film(@JsonProperty("id") FilmId id,
                   @JsonProperty("filmName") String name,
                   @JsonProperty("price") Money price,
                   @JsonProperty("numadded") int addednum) {
        this.filmId = id;
        this.name = name;
        this.price = price;
        this.addednum = addednum;
    }
}
