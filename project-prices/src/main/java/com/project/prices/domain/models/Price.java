package com.project.prices.domain.models;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Price {

    private int productId;

    private int brandId;

    private int priceList;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Double price;

    public Price(int productId, int brandId, int priceList, LocalDateTime startDate, LocalDateTime endDate, Double price) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Price{" +
                "productId=" + productId +
                ", brandId=" + brandId +
                ", priceList=" + priceList +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                '}';
    }
}
