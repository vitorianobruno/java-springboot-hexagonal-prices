package com.project.prices.persistence.adapters;

import com.project.prices.domain.ports.PricePersistencePort;
import com.project.prices.persistence.entities.PriceEntity;
import com.project.prices.persistence.repositories.PriceRepository;
import org.springframework.stereotype.Component;

@Component
public class PricePersistencePortAdapter implements PricePersistencePort {

    private final PriceRepository priceRepository;

    public PricePersistencePortAdapter(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }


    @Override
    public PriceEntity findBySearch(int productId) {
        return priceRepository.findBySearch(productId);

    }

}