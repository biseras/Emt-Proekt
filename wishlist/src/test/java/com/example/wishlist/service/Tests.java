package com.example.wishlist.service;

import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import com.example.wishlist.domain.exceptions.WishlistException;
import com.example.wishlist.domain.model.Wishlist;
import com.example.wishlist.domain.model.WishlistId;
import com.example.wishlist.domain.valueobjacts.Film;
import com.example.wishlist.domain.valueobjacts.FilmId;
import com.example.wishlist.service.forms.WishlistForm;
import com.example.wishlist.service.forms.WishlistItemForm;
import com.example.wishlist.xport.client.FilmClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class Tests {
    @Autowired
    private WishlistService wishlistService;

    @Autowired
    private FilmClient filmClient;



//    private static Film newProduct(String name, Money price) {
//        Film f = new Film(FilmId.randomId(FilmId.class), name, price, 0);
//        return f;
//    }

    @Test
    public void testPlaceOrder() {

        WishlistItemForm wishlistItemForm = new WishlistItemForm();
        wishlistItemForm.setFilm(new Film("Pizza", Money.valueOf(Currency.EUR,1500), 9));
        wishlistItemForm.setKvalitet(1);

        WishlistItemForm wishlistItemForm1 = new WishlistItemForm();
        wishlistItemForm1.setFilm(new Film("Pizzaaa", Money.valueOf(Currency.EUR,500), 3));
        wishlistItemForm1.setKvalitet(1);

        WishlistForm wishlistForm = new WishlistForm();
        wishlistForm.setCurrency(Currency.EUR);
        wishlistForm.setItems(Arrays.asList(wishlistItemForm,wishlistItemForm1));

        WishlistId newOrderId = wishlistService.placeorder(wishlistForm);
        Wishlist newOrder = wishlistService.findById(newOrderId).orElseThrow(WishlistException::new);
        Assertions.assertEquals(newOrder.total(),Money.valueOf(Currency.EUR,2000));

    }

//    @Test
//    public void testPlaceOrderWithRealData() {
//        List<Product> productList = productClient.findAll();
//        Product p1 = productList.get(0);
//        Product p2 = productList.get(1);
//
//        OrderItemForm oi1 = new OrderItemForm();
//        oi1.setProduct(p1);
//        oi1.setQuantity(1);
//
//        OrderItemForm oi2 = new OrderItemForm();
//        oi2.setProduct(p2);
//        oi2.setQuantity(2);
//
//        OrderForm orderForm = new OrderForm();
//        orderForm.setCurrency(Currency.MKD);
//        orderForm.setItems(Arrays.asList(oi1,oi2));
//
//        OrderId newOrderId = orderService.placeOrder(orderForm);
//        Order newOrder = orderService.findById(newOrderId).orElseThrow(OrderIdNotExistException::new);
//
//        Money outMoney = p1.getPrice().multiply(oi1.getQuantity()).add(p2.getPrice().multiply(oi2.getQuantity()));
//        Assertions.assertEquals(newOrder.total(),outMoney);
//    }

    @Test
    public void testPlaceOrderWithRealData() {
        List<Film> filmList = filmClient.findAll();
        System.out.println(filmList);
    }
}
