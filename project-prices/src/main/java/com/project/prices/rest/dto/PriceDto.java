package com.project.prices.rest.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class PriceDto {

    private String startDate;

    private int productId;

    private int brandId;

    public PriceDto(String startDate, int productId, int brandId) {
        this.startDate = startDate;
        this.productId = productId;
        this.brandId = brandId;
    }
}
