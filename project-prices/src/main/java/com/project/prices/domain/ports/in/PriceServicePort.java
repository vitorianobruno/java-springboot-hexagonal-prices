package com.project.prices.domain.ports.in;

import com.project.prices.domain.models.Price;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public interface PriceServicePort {

    ResponseEntity<Price> getPrice(LocalDateTime start_date, int product_id, int brand_id);
}
