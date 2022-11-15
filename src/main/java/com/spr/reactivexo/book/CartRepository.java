package com.spr.reactivexo.book;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CartRepository  extends ReactiveCrudRepository<Cart, String> {
}
