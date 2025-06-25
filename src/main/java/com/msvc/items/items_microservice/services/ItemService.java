package com.msvc.items.items_microservice.services;

import com.msvc.items.items_microservice.models.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> findAll();
    Optional<Item> findById(Long id);
}
