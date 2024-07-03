package com.project.prices.domain.ports;

import com.project.prices.persistence.entities.PriceEntity;

public interface PricePersistencePort {

    PriceEntity findBySearch(int productId);
}
