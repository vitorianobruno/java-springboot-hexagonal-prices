package com.project.prices.persistence.entities;

import com.project.prices.domain.models.Price;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = PriceEntity.PRICE)
public class PriceEntity {

    static final String PRICE = "prices";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int productId;

    private int brandId;

    private int priceList;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private int priority;

    private Double price;

    private String curr;

    public Price toDomainModel() {
        return new Price(productId, brandId, priceList, startDate, endDate, price);
    }

}
