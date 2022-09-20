package com.example.wishlist.domain.valueobjacts;

import com.example.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class FilmId extends DomainObjectId {
    private FilmId() {
        super(FilmId.randomId(FilmId.class).getId());
    }

    public FilmId(String uuid) {
        super(uuid);
    }

}
