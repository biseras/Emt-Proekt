package com.example.wishlist.domain.model;

import com.example.sharedkernel.domain.base.DomainObjectId;

public class FilmWishlistId extends DomainObjectId {
    private FilmWishlistId() {
        super(FilmWishlistId.randomId(FilmWishlistId.class).getId());
    }

    public FilmWishlistId(String uuid) {
        super(uuid);
    }

}
