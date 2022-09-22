package com.example.wishlist.service.forms;

import com.example.sharedkernel.domain.base.DomainObjectId;
import com.example.wishlist.domain.model.WishlistId;
import lombok.NonNull;

public class WishlistItemId extends DomainObjectId {
    private WishlistItemId() {
        super(WishlistItemId.randomId(WishlistItemId.class).getId());
    }

    public WishlistItemId(@NonNull String uuid) {
        super(uuid);
    }
}
