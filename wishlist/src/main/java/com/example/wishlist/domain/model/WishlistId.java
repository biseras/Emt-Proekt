package com.example.wishlist.domain.model;

import com.example.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class WishlistId extends DomainObjectId {
    private WishlistId() {
        super(WishlistId.randomId(WishlistId.class).getId());
    }

    public WishlistId(@NonNull String uuid) {
        super(uuid);
    }



}
