package com.spr.reactivexo.book;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CartService cartService;

    public HomeController(ItemRepository itemRepository, CartRepository cartRepository) {
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
    }


    // tag::2[]
    /**
    @GetMapping
    Mono<Rendering> home() { // <1>
        return Mono.just(Rendering.view("home.html") // <2>
                .modelAttribute("items", //
                        this.itemRepository.findAll().doOnNext(System.out::println)) // <3>
                .modelAttribute("cart", //
                        this.cartRepository.findById("My Cart") // <4>
                                .defaultIfEmpty(new Cart("My Cart")))
                .build());
    }
    // end::2[]
**/
    /**
     * 화면에서 Add to Cart 버튼클릭 시
     * 1.@PostMapping add/{id}로 들어오는 POST 요청을 이 메소드에 매핑해준다.
     * 2.@PathVariable 은 {id}자리로 들어오는 값을 추출해서 id로 지정된 파라미터에 해당 값을 주입한다.
     * 3.몽고디비에서 'My Cart'를 찾아서 없으면 defaultIfEmpty 를 통해 새로 생성해 반환한다. 앞에서도
     *   살펴본 전형적인 리액터 사용법이다.
     * 4. 장바구니 데이터를 가져온 후에 가장 먼저 해야 할 일은 장바구니에 담겨 있는 상품이 있는지 확인하는 것이다.
     *   전통적인 기존 방식이라면 for-each 반복문으로 처리했겠지만, 자바의 스트림 API 덕분에 CartItem 을 순회하면서
     *   새로 장바구니에 담은 것과 동일한 종류의 상품이 이미 있는지 확인할 수 있다. findAny()는 Optional<CartItem> 을
     *   반환하며, 같은 상품이 있다면 map() 내부에서 해당 상품의 수량만 증가시키고 장바구니를 Mono에 담아 반환한다.
     * 5.새로 장바구니에 담은 상품이 장바구니에 담겨 있지 않은 상품이라면, 몽고디비에서 해당 상품을 조회 한 후 수량을
     *   1로 지정하고 CartItem 에 담은 다음, CartItem 을 장바구니에 추가한 후에 장바구니를 반환한다. 이 과정은 장바구니에
     *   동일한 상품이 없을 때만 수행되므로 하나의 람다식에서 모두 처리한다.
     * 6.업데이트된 장바구니를 몽고디비에 저장한다.
     * 7.redirect:/ 반환하며 웹플럭스가 HTTP 요청을 / 위치로 리다이렉트한다.
     */

    // tag::3[]
    /**
    @PostMapping("/add/{id}") // <1>
    Mono<String> addToCart(@PathVariable String id) { // <2>
        return this.cartRepository.findById("My Cart") //
                .defaultIfEmpty(new Cart("My Cart")) // <3>
                .flatMap(cart -> cart.getCartItems().stream() // <4>
                        .filter(cartItem -> cartItem.getItem() //
                                .getId().equals(id)) //
                        .findAny() //
                        .map(cartItem -> {
                            cartItem.increment();
                            return Mono.just(cart);
                        }) //
                        .orElseGet(() -> { // <5>
                            return this.itemRepository.findById(id) //
                                    .map(item -> new CartItem(item)) //
                                    .map(cartItem -> {
                                        cart.getCartItems().add(cartItem);
                                        return cart;
                                    });
                        }))
                .flatMap(cart -> this.cartRepository.save(cart)) // <6>
                .thenReturn("redirect:/"); // <7>
    }
    */

    //위의 소스를 서비스로 옮기면 간결해진다.

    @PostMapping("/add/{id}") // <1>
    Mono<String> addToCart(@PathVariable String id){
        return this.cartService.addToCart("My Cart", id)
                .thenReturn("redirect:/");
    }

    // end::3[]

    @PostMapping
    Mono<String> createItem(@ModelAttribute Item newItem) {
        return this.itemRepository.save(newItem) //
                .thenReturn("redirect:/");
    }

    @DeleteMapping("/delete/{id}")
    Mono<String> deleteItem(@PathVariable String id) {
        return this.itemRepository.deleteById(id) //
                .thenReturn("redirect:/");
    }

}
