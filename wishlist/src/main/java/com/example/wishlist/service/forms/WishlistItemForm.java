package com.example.wishlist.service.forms;

import com.example.wishlist.domain.valueobjacts.Film;
import javax.validation.constraints.NotNull;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class WishlistItemForm {
    @NotNull
    private Film film;
    @Min(1)
    private int kvalitet=1;
}
