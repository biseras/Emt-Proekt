package com.example.wishlist.service.forms;

import com.example.sharedkernel.domain.financial.Money;
import com.example.wishlist.domain.model.WishlistId;
import com.example.wishlist.domain.valueobjacts.Film;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

import javax.validation.constraints.Min;
import java.util.Random;
import java.util.UUID;


@Data
public class WishlistItemForm {
    @NotNull
    private Film film;
    @Min(1)
    private int kvalitet=1;
}
