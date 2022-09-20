package com.example.wishlist.service.forms;

import com.example.sharedkernel.domain.financial.Currency;
import com.example.wishlist.domain.valueobjacts.Film;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class WishlistForm {
    @NotNull
    private Currency currency;
    @Valid
    @NotEmpty
    private List<WishlistItemForm> items=new ArrayList<>();
}
