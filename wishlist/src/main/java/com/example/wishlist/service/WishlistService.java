package com.example.wishlist.service;

import com.example.wishlist.domain.exceptions.WishlistException;
import com.example.wishlist.domain.model.FilmWishlistId;
import com.example.wishlist.domain.model.WishListAndFilmDTO;
import com.example.wishlist.domain.model.Wishlist;
import com.example.wishlist.domain.model.WishlistId;
import com.example.wishlist.service.forms.FilmIdDTO;
import com.example.wishlist.service.forms.WishlistForm;
import com.example.wishlist.service.forms.WishlistItemForm;

import java.util.List;
import java.util.Optional;

public interface WishlistService {
    WishlistId placeorder(WishlistForm orderForm);
    List<Wishlist> findAll();
    Optional<String> addtowishlist(FilmIdDTO filmIdDTO);
    Optional<Wishlist>findById(WishlistId id);
//    void addItem(WishlistId wishlistId, WishlistItemForm wishlistItemForm) throws WishlistException;
//    void deleteItem(WishlistId wishlistId, FilmWishlistId filmWishlistId) throws WishlistException;

    List<WishListAndFilmDTO> getAll();
}
