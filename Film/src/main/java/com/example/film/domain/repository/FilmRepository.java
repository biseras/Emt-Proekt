package com.example.film.domain.repository;

import com.example.film.domain.models.Film;
import com.example.film.domain.models.FilmId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, FilmId> {
}
