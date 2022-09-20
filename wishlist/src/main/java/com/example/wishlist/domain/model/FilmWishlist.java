package com.example.wishlist.domain.model;

import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.base.DomainObjectId;
import com.example.sharedkernel.domain.financial.Money;
import com.example.wishlist.domain.valueobjacts.FilmId;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "wishlist_film")
@Getter
public class FilmWishlist extends AbstractEntity<FilmWishlistId> {
    private Money wishlistfilmprice;
    private int kvalitet;
    @AttributeOverride(name = "id", column = @Column(name = "filmm_id", nullable = false))
    private FilmId filmId;
    private FilmWishlist() {
        super(DomainObjectId.randomId(FilmWishlistId.class));
    }

    public FilmWishlist(@NonNull FilmId filmId, @NonNull Money price, int kvalitet){
        super(DomainObjectId.randomId(FilmWishlistId.class));
        this.filmId=filmId;
        this.wishlistfilmprice=price;
        this.kvalitet=kvalitet;
    }
    public Money subtotal()
    {
        return wishlistfilmprice.multiply(kvalitet);
    }
}
