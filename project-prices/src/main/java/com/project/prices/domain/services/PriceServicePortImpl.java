package com.project.prices.domain.services;

import com.project.prices.domain.exceptions.NotFoundException;
import com.project.prices.domain.models.Price;
import com.project.prices.domain.ports.out.PricePersistencePort;
import com.project.prices.domain.ports.in.PriceServicePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
public class PriceServicePortImpl implements PriceServicePort {

    private final PricePersistencePort pricePersistencePort;

    public PriceServicePortImpl(PricePersistencePort pricePersistencePort) {
        this.pricePersistencePort = pricePersistencePort;
    }

    /*@Override
    public Optional<Price> getPriceById(Long id) {
        return pricePersistencePort.findById(id);
    }*/

    @Override
    public ResponseEntity<Price> getPrice(LocalDateTime start_date, int product_id, int brand_id) {
        return new ResponseEntity<Price> (pricePersistencePort.findBySearch(product_id, brand_id, start_date).toDomainModel(), HttpStatus.OK);
    }

}
