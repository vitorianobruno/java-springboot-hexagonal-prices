package com.project.prices.domain.services.impl;

import com.project.prices.domain.ports.PricePersistencePort;
import com.project.prices.domain.services.PriceService;
import com.project.prices.persistence.entities.PriceEntity;

import java.util.Date;

public class PriceServiceImpl implements PriceService {

    private final PricePersistencePort pricePersistencePort;

    public PriceServiceImpl(PricePersistencePort pricePersistencePort) {
        this.pricePersistencePort = pricePersistencePort;
    }

    @Override
    public PriceEntity getPrice(Date start_date, int product_id, int brand_id) {
        return pricePersistencePort.findBySearch(product_id);
    }

}
