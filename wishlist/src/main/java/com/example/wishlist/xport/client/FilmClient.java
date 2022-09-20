package com.example.wishlist.xport.client;

import com.example.wishlist.domain.valueobjacts.Film;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class FilmClient {
    private final RestTemplate restTemplate;
    private final String serverURL;
    public FilmClient(@Value("${app.Film.url}") String serverURL)
    {
        this.serverURL=serverURL;
        this.restTemplate=new RestTemplate();
        var requestfactory=new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestfactory);
    }
    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverURL);
    }

    public List<Film> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/film").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<Film>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
    public Film getWithGivenId(String uuid){
        Map<String, String> map = new HashMap<>();
        map.put("id", uuid);
        Film film = restTemplate.postForObject(uri().path("/api/film/get").build().toUri(), map, Film.class);
        return film;

    }
}
