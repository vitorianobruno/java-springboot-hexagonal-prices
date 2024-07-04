package com.project.prices.domain.ports.out;

import com.project.prices.domain.models.Price;
import com.project.prices.persistence.entities.PriceEntity;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PricePersistencePort {

    //Optional<Price> findById(Long id);

    PriceEntity findBySearch(int productId, int brandId, LocalDateTime date);
}
