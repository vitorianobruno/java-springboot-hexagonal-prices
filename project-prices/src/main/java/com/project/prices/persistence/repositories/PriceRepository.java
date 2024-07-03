package com.project.prices.persistence.repositories;

import com.project.prices.persistence.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query("select p from PriceEntity p where p.productId = :productId")
    PriceEntity findBySearch(@Param("productId") int productId);

}
