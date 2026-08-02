package com.marktplace.service;

import com.marktplace.database.model.Products;
import com.marktplace.database.repository.IProductsRepository;
import com.marktplace.dto.ProductsProjection;
import com.marktplace.dto.ProductsResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductsService {


    private final IProductsRepository productsRepository;

    public ProductsService(IProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }


    public List<Products> getProducts(){
       return productsRepository.findAll();
    }

    public void  postProducts(ProductsResponseDto productsDto){

        productsRepository.save(
                Products.builder()
                        .name(productsDto.getName())
                        .category(productsDto.getCategory())
                        .description(productsDto.getDescription())
                        .price(productsDto.getPrice())
                        .build()
        );

    }


    public Page<ProductsProjection> getProductsPage(String search, Integer page, Integer size){

        Pageable pg = PageRequest.of(page,size);

       return productsRepository.getAllProductsPage(search, pg);
    }
}
