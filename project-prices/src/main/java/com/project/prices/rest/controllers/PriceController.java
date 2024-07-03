package com.project.prices.rest.controllers;

import com.project.prices.domain.services.PriceService;
import com.project.prices.persistence.entities.PriceEntity;
import com.project.prices.rest.dtos.PriceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(PriceController.PRICES)
public class PriceController {

    static final String PRICES = "/prices";

    private PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @RequestMapping(method=RequestMethod.POST, consumes="application/json")
    public ResponseEntity<PriceEntity> search(@Valid @RequestBody PriceDto priceDto) {
        PriceEntity priceEntity = priceService.getPrice(priceDto.getDate(), priceDto.getProduct_id(), priceDto.getBrand_id());
        return ResponseEntity.ok(priceEntity);
        //return ResponseEntity.ok(priceService.getPrice(priceDto.getDate(), priceDto.getProduct_id(), priceDto.getBrand_id()));
    }

}
