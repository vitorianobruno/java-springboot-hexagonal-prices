package com.project.prices.persistence.adapters;

import com.project.prices.domain.exceptions.NotFoundException;
import com.project.prices.domain.ports.out.PricePersistencePort;
import com.project.prices.persistence.entities.PriceEntity;
import com.project.prices.persistence.repositories.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class PricePersistencePortAdapter implements PricePersistencePort {

    private final PriceRepository priceRepository;

    public PricePersistencePortAdapter(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    /*@Override
    public Optional<Price> findById(Long id) {
        return priceRepository.findById(id).map(PriceEntity::toDomainModel);
    }*/

    @Override
    public PriceEntity findBySearch(int productId, int brandId, LocalDateTime date) {
        if (priceRepository.findBySearch(productId, brandId, date) != null) {
            return priceRepository.findBySearch(productId, brandId, date);
        } else {
            throw new NotFoundException("No price found in this range date.");
        }
    }

}