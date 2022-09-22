package com.example.wishlist.service.impl;

import com.example.sharedkernel.domain.financial.Currency;
import com.example.wishlist.domain.exceptions.WishlistException;
import com.example.wishlist.domain.model.WishListAndFilmDTO;
import com.example.wishlist.domain.model.Wishlist;
import com.example.wishlist.domain.model.WishlistId;
import com.example.wishlist.domain.repository.WishListRepository;
import com.example.wishlist.domain.valueobjacts.Film;
import com.example.wishlist.service.WishlistService;
import com.example.wishlist.service.forms.FilmIdDTO;
import com.example.wishlist.service.forms.WishlistForm;
import com.example.wishlist.service.forms.WishlistItemForm;
import com.example.wishlist.xport.client.FilmClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class WishListServiceImpl implements WishlistService {
    private final WishListRepository wishListRepository;
    private final Validator validator;
    private final FilmClient filmClient;

    public WishListServiceImpl(WishListRepository wishListRepository, Validator validator, FilmClient filmClient) {
        this.wishListRepository = wishListRepository;
        this.validator = validator;
        this.filmClient = filmClient;
    }

    @Override
    public WishlistId placeorder(WishlistForm wishlistForm) {
        Objects.requireNonNull(wishlistForm,"order must not be null.");
        var constraintViolations = validator.validate(wishlistForm);
        if (constraintViolations.size()>0) {
            throw new ConstraintViolationException("The order form is not valid", constraintViolations);
        }
        var newWishlist = wishListRepository.saveAndFlush(toDomainObject(wishlistForm));
        //Wishlist wishlist=this.wishListRepository.findById(newWishlist.getId());
        //newWishlist.getFilmWishlistSet().forEach(item->domainEventPublisher.publish(new OrderItemCreated(item.getFilmId().getId(),item.getKvalitet())));
        return newWishlist.getId();

    }
    @Transactional
    @Override
    public Optional<String> addtowishlist(FilmIdDTO filmId) {
        WishlistItemForm wishlistItemForm=new WishlistItemForm();
        wishlistItemForm.setFilm(this.filmClient.getWithGivenId(filmId.getFilmId()));
        wishlistItemForm.setKvalitet(3);
        WishlistForm wishlistForm=new WishlistForm();
        wishlistForm.setItems(List.of(wishlistItemForm));
        wishlistForm.setCurrency(Currency.USD);
        WishlistId wishlistId=this.placeorder(wishlistForm);
        findById(wishlistId).orElseThrow(WishlistException::new);
        return Optional.of("Successfully added");
    }
    @Override
    public List<Wishlist> findAll() {
        return wishListRepository.findAll();
    }

    @Override
    public Optional<Wishlist> findById(WishlistId id) {
        return wishListRepository.findById(id);
    }

//    @Override
//    public void addItem(WishlistId wishlistId, WishlistItemForm wishlistItemForm) throws WishlistException {
//        Wishlist wishlist=wishListRepository.findById(wishlistId).orElseThrow(WishlistException::new);
//        wishlist.addItem(wishlistItemForm.getFilm(), wishlistItemForm.getKvalitet());
//        wishListRepository.saveAndFlush(wishlist);
//    }
//
//    @Override
//    public void deleteItem(WishlistId wishlistId, FilmWishlistId filmWishlistId) throws WishlistException {
//        Wishlist wishlist=wishListRepository.findById(wishlistId).orElseThrow(WishlistException::new);
//        wishlist.removeItem(filmWishlistId);
//        wishListRepository.saveAndFlush(wishlist);
//    }

    @Override
    public List<WishListAndFilmDTO> getAll() {
        List<Wishlist> wishlists = this.wishListRepository.findAll();
        List<WishListAndFilmDTO> wishListAndFilmDTOS = new ArrayList<>();
        WishListAndFilmDTO wishListAndFilmDTO = new WishListAndFilmDTO();
        wishlists
                .stream().forEach(v -> {
                    wishListAndFilmDTO.setId(v.getId().getId());
//                    wishListAndFilmDTO.setFilm(this.filmClient.getWithGivenId(v.getFilmWishlistSet().));
                });
        return null;
    }

    private Wishlist toDomainObject(WishlistForm wishlistForm) {
        var wishlist = new Wishlist(Instant.now(),wishlistForm.getCurrency());
        wishlistForm.getItems().forEach(item->wishlist.addItem(item.getFilm(),item.getKvalitet(), item.getFilm().getName()));
        return wishlist;
    }

}
