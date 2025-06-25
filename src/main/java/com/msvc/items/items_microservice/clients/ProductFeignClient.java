package com.msvc.items.items_microservice.clients;

import com.msvc.items.items_microservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "localhost:8080/api/products", name = "products-microservice")
public interface ProductFeignClient {
    @GetMapping
    List<Product> findAllProducts();

    @GetMapping("/{id}")
    Product findProductById(@PathVariable Long id);
}
