package com.spr.reactivexo;

import org.springframework.data.repository.CrudRepository;

public interface BlockingItemRepository extends CrudRepository<Item, String> {
}
