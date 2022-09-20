package com.example.film.services.impl;

import com.example.film.domain.exception.FilmNotFound;
import com.example.film.domain.models.Film;
import com.example.film.domain.models.FilmId;
import com.example.film.domain.models.FilmIdDTO;
import com.example.film.domain.repository.FilmRepository;
import com.example.film.services.FilmService;
import com.example.film.services.form.FilmForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;

    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Optional<Film> findById(FilmIdDTO filmid) {
        Film film=this.filmRepository.findById(FilmId.of(filmid.getId())).orElseThrow(FilmNotFound::new);
        return Optional.of(film);
    }

    @Override
    public Optional<Film> createFilm(FilmForm form) {
        Film f=Film.build(form.getFilmName(), form.getPrice(), form.getNumadded());
        filmRepository.save(f);
        return Optional.of(f);
    }

    @Override
    public Film orderItemCreated(FilmId filmId) {
        Film f = filmRepository.findById(filmId).orElseThrow(FilmNotFound::new);
        f.addSales();
        filmRepository.saveAndFlush(f);
        return f;

    }

    @Override
    public Film orderItemRemoved(FilmId filmId) {
        Film f = filmRepository.findById(filmId).orElseThrow(FilmNotFound::new);
        f.removeSales();
        filmRepository.saveAndFlush(f);
        return f;
    }

    @Override
    public List<Film> getAll() {
        return filmRepository.findAll();
    }
}
