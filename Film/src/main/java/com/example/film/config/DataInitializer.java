package com.example.film.config;

import com.example.film.domain.models.Film;
import com.example.film.domain.repository.FilmRepository;
import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final FilmRepository filmRepository;

    @PostConstruct
    public void initData() {
        Film p1 = Film.build("Pizza", Money.valueOf(Currency.EUR,500), 10);
        Film p2 = Film.build("Ice Cream", Money.valueOf(Currency.EUR,100), 5);
        if (filmRepository.findAll().isEmpty()) {
            filmRepository.saveAll(Arrays.asList(p1,p2));
        }
    }

}
