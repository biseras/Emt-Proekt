package com.example.wishlist.domain.model;

import com.example.wishlist.domain.valueobjacts.Film;
import lombok.Data;

@Data
public class WishListAndFilmDTO {
    private String id;
    private Film film;
}
