package com.project.prices.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;

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

    private String startDate;

    private String endDate;

    private int priority;

    private Double price;

    private String curr;

}
