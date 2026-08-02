package com.marktplace.database.repository;

import com.marktplace.database.model.Products;
import com.marktplace.dto.ProductsProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductsRepository extends JpaRepository<Products, Long> {

    @Query(value = """
    SELECT *
    FROM products p
    WHERE to_tsvector(
        'portuguese',
        coalesce(p.name, '') || ' ' || coalesce(p.description, '')
    ) @@ plainto_tsquery('portuguese', :search)
    """,
            countQuery = """
    SELECT COUNT(*)
    FROM products p
    WHERE to_tsvector(
        'portuguese',
        coalesce(p.name, '') || ' ' || coalesce(p.description, '')
    ) @@ plainto_tsquery('portuguese', :search)
    """,
            nativeQuery = true)
    Page<ProductsProjection> getAllProductsPage(
            @Param("search") String search,
            Pageable pageable
    );
}
