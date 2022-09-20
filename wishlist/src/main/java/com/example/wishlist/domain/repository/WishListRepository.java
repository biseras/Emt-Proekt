package com.example.wishlist.domain.repository;

import com.example.wishlist.domain.model.Wishlist;
import com.example.wishlist.domain.model.WishlistId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<Wishlist, WishlistId> {
}
