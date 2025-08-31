package com.project.prices.domain.ports.in;

import com.project.prices.domain.models.Price;
import java.time.LocalDateTime;

public interface PriceServicePort {
    Price getPrice(LocalDateTime start_date, int product_id, int brand_id);
}
