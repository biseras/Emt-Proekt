package com.example.wishlist.domain.model;

import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import com.example.wishlist.domain.valueobjacts.Film;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "wishlist")
@Getter
public class Wishlist extends AbstractEntity<WishlistId> {
    private Instant addedOn;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<FilmWishlist> filmWishlistSet= new HashSet<>();
    private Wishlist(){
        super(WishlistId.randomId(WishlistId.class));
    }
    public Wishlist(Instant now, com.example.sharedkernel.domain.financial.Currency currency){
        super(WishlistId.randomId(WishlistId.class));
        this.addedOn=now;
        this.currency=currency;
    }

    public Money total(){
        return filmWishlistSet.stream().map(FilmWishlist::subtotal).reduce(new Money(currency, 0),Money::add);
    }
    public FilmWishlist addItem(@NonNull Film film, int kvalitet)
    {
        Objects.requireNonNull(film,"product must not be null");
        var item  = new FilmWishlist(film.getFilmId(),film.getPrice(),kvalitet);
        filmWishlistSet.add(item);
        return item;
    }

    public void removeItem(@NonNull FilmWishlistId filmWishlistId) {
        Objects.requireNonNull(filmWishlistId,"Order Item must not be null");
        filmWishlistSet.removeIf(v->v.getId().equals(filmWishlistId));
    }

}
