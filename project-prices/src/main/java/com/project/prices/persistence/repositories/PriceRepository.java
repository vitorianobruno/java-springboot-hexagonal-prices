package com.project.prices.persistence.repositories;

import com.project.prices.persistence.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM PRICES WHERE product_id = :productId AND brand_id = :brandId AND :date BETWEEN start_date AND end_date ORDER BY priority DESC LIMIT 1")
    //@Query("SELECT p FROM PriceEntity p WHERE p.productId = :productId AND p.brandId = :brandId AND p.startDate >= :date AND p.endDate <= :date")
    //@Query("SELECT p FROM PriceEntity p WHERE p.productId = :productId AND p.brandId = :brandId AND :date BETWEEN p.startDate AND p.endDate")
    PriceEntity findBySearch(@Param("productId") int productId, @Param("brandId") int brandId, @Param("date") LocalDateTime date);

}
