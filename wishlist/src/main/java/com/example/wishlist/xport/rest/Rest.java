package com.example.wishlist.xport.rest;

import com.example.wishlist.domain.model.Wishlist;
import com.example.wishlist.domain.model.WishlistId;
import com.example.wishlist.domain.valueobjacts.Film;
import com.example.wishlist.service.WishlistService;
import com.example.wishlist.service.forms.FilmIdDTO;
import com.example.wishlist.service.forms.WishlistForm;
import com.example.wishlist.service.forms.WishlistItemForm;
import com.example.wishlist.xport.client.FilmClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wihslist")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000/")
public class Rest {
    private final WishlistService wishlistService;
    private final FilmClient filmClient;
    @GetMapping
    private List<Wishlist> listAll(){
        return this.wishlistService.findAll();
    }
    @PostMapping(value = "/additem")
    private ResponseEntity<String> addtowishlist(@RequestBody FilmIdDTO filmIdDTO){
        return this.wishlistService.addtowishlist(filmIdDTO)
                .map(v -> ResponseEntity.ok().body(v))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
