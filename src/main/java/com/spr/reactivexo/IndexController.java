package com.spr.reactivexo;

import com.spr.reactivexo.book.Cart;
import com.spr.reactivexo.book.CartRepository;
import com.spr.reactivexo.book.CartService;
import com.spr.reactivexo.book.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
public class IndexController {

    private ItemRepository itemRepository;
    private CartRepository cartRepository;

    @Autowired
    private CartService cartService;

    public IndexController(ItemRepository itemRepository, CartRepository cartRepository) {
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
    }

    @GetMapping("/book/index")
    Mono<Rendering> home() { // <1>
        return Mono.just(Rendering.view("home.html") // <2>
                .modelAttribute("items", //
                        this.itemRepository.findAll().doOnNext(System.out::println)) // <3>
                .modelAttribute("cart", //
                        this.cartRepository.findById("My Cart") // <4>
                                .defaultIfEmpty(new Cart("My Cart")))
                .build());
    }

}
