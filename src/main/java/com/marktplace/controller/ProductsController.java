package com.marktplace.controller;

import com.marktplace.database.model.Products;
import com.marktplace.dto.ProductsProjection;
import com.marktplace.dto.ProductsResponseDto;
import com.marktplace.service.ProductsService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService){
        this.productsService = productsService;
    }

    @GetMapping()
    public Page<ProductsProjection> getProductsPage(@RequestParam  String search,
                                                    @RequestParam Integer page,
                                                    @RequestParam Integer size){
        return productsService.getProductsPage(search, page, size);
    }

    @GetMapping("/all")
    public List<Products> getAllProducts(){
        return productsService.getProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postProducts(@RequestBody ProductsResponseDto productsResponseDto){
        productsService.postProducts(productsResponseDto);
    }

}
