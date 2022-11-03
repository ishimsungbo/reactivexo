package com.spr.reactivexo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
public class HomeController {

    //주입하자
    private ItemRepository itemRepository;
    private CartRepository cartRepository;

    public HomeController(ItemRepository itemRepository, CartRepository cartRepository) {
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
    }


    // tag::2[]
    @GetMapping
    Mono<Rendering> home() { // <1>
        return Mono.just(Rendering.view("home.html") // <2>
                .modelAttribute("items", //
                        this.itemRepository.findAll()) // <3>
                .modelAttribute("cart", //
                        this.cartRepository.findById("My Cart") // <4>
                                .defaultIfEmpty(new Cart("My Cart")))
                .build());
    }
    // end::2[]




}
