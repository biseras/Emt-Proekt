package com.example.film.domain.models;

import com.example.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class FilmId extends DomainObjectId {
    private FilmId() {
        super(FilmId.randomId(FilmId.class).getId());
    }

    public FilmId(@NonNull String uuid) {
        super(uuid);
    }

    public static FilmId of(String uuid) {
        FilmId p = new FilmId(uuid);
        return p;
    }

}
