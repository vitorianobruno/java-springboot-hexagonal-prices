package com.project.prices.rest.controller;

import com.project.prices.domain.exceptions.BadRequestException;
import com.project.prices.domain.models.Price;
import com.project.prices.domain.ports.in.PriceServicePort;
import com.project.prices.rest.dto.PriceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(PriceController.PRICES)
@Slf4j
public class PriceController {

    static final String PRICES = "/prices";

    private PriceServicePort priceServicePort;

    public PriceController(PriceServicePort priceServicePort) {
        this.priceServicePort = priceServicePort;
    }

    /*@GetMapping("/{priceId}")
    public ResponseEntity<Price> getTaskById(@PathVariable Long priceId) {
        return priceServicePort.getPriceById(priceId)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }*/

    @RequestMapping(method=RequestMethod.POST, consumes="application/json")
    public ResponseEntity<Price> search(@Valid @RequestBody PriceDto priceDto) {
        try {
            return priceServicePort.getPrice(formatDate(priceDto.getStartDate()), priceDto.getProductId(), priceDto.getBrandId());
        } catch (Exception e) {
            log.warn("Couldn't serialize response");
            throw e;
        }

    }

    public LocalDateTime formatDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
            return LocalDateTime.parse(date, formatter);
        } catch (Exception e) {
            log.error("Invalid format datetime.");
            throw new BadRequestException(e.getMessage());
        }
    }

}
