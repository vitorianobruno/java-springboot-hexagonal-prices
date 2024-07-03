package com.project.prices.rest.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PriceDto {

    private Date date;
    private int product_id;
    private int brand_id;

}
