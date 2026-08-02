package com.marktplace.service;

import com.marktplace.database.model.Products;
import com.marktplace.database.repository.IProductsRepository;
import com.marktplace.dto.ProductsProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
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


    public Page<ProductsProjection> getProductsPage(String search, Integer page, Integer size){

        Pageable pg = PageRequest.of(page,size);

       return productsRepository.getAllProductsPage(search, pg);
    }
}
