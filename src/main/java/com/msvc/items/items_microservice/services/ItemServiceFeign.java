package com.msvc.items.items_microservice.services;

import com.msvc.items.items_microservice.clients.ProductFeignClient;
import com.msvc.items.items_microservice.models.Item;
import com.msvc.items.items_microservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ItemServiceFeign implements ItemService {
    private final ProductFeignClient productFeignClient;
    public ItemServiceFeign(ProductFeignClient productFeignClient) {
        this.productFeignClient = productFeignClient;
    }

    Random random = new Random();

    @Override
    public List<Item> findAll() {
        return productFeignClient.findAllProducts().stream().map(product -> {

            //random nextInt genera un numero entre el 0 y el 9, le agregamos 1 para que sea entre 1 y 10
            return new Item(product, random.nextInt(10) + 1);
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<Item> findById(Long id) {
        Product product = productFeignClient.findProductById(id);
        if(product == null) {
            return Optional.empty();
        }
        return Optional.of(new Item(productFeignClient.findProductById(id), random.nextInt(10) + 1));
    }
}
