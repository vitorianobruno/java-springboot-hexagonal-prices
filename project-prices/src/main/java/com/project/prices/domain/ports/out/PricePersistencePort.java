package com.project.prices.domain.ports.out;

import com.project.prices.persistence.entities.PriceEntity;

import java.time.LocalDateTime;

public interface PricePersistencePort {

    PriceEntity findBySearch(int productId, int brandId, LocalDateTime date);
}
