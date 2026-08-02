package com.marktplace.controller;

import com.marktplace.dto.ProductsProjection;
import com.marktplace.dto.ProductsRequestDto;
import com.marktplace.service.ProductsService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService){
        this.productsService = productsService;
    }

    @GetMapping
    public Page<ProductsProjection> getProductsPage(@Valid @RequestParam  String search,
                                                    @PathVariable Integer page,
                                                    @PathVariable Integer size){
        return productsService.getProductsPage(search, page, size);
    }
}
