package com.project.prices.domain.services;

import com.project.prices.persistence.entities.PriceEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface PriceService {

    PriceEntity getPrice(Date start_date, int product_id, int brand_id);

}
