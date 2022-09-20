package com.example.film.services;

import com.example.film.domain.models.Film;
import com.example.film.domain.models.FilmId;
import com.example.film.domain.models.FilmIdDTO;
import com.example.film.services.form.FilmForm;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    Optional<Film> findById(FilmIdDTO id);
    Optional<Film> createFilm(FilmForm form);
    Film orderItemCreated(FilmId filmId);
    Film orderItemRemoved(FilmId filmId);
    List<Film> getAll();
}
