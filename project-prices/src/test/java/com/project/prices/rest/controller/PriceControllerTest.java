package com.project.prices.rest.controller;

import com.project.prices.domain.models.Price;
import com.project.prices.domain.ports.in.PriceServicePort;
import com.project.prices.rest.dto.PriceDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PriceControllerTest {


    @Mock
    private PriceServicePort priceServicePort;

    @InjectMocks
    private PriceController priceController;


    @Test
    void getPrice_SuccessResponse() {

        ResponseEntity<Price> expected = new ResponseEntity<>(new Price(35455,1,1, LocalDateTime.of(2020,06,14,00,00,00), LocalDateTime.of(2020,12,31,23,59,59), 35.5), HttpStatus.OK);

        when(priceServicePort.getPrice(ArgumentMatchers.any(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()))
                .thenReturn(expected);

        ResponseEntity<Price> responseEntity = priceController.search(PriceDto.builder().productId(35455).brandId(1).startDate("2020-06-14-10.00.00").build());

        assertEquals(responseEntity, expected);
        //assertNotNull(responseEntity.getBody());
        verify(priceServicePort, times(1)).getPrice(ArgumentMatchers.any(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
    }

    @Test
    void getPrice_ErrorWhenExceptionThrown() {

        when(priceServicePort.getPrice(ArgumentMatchers.any(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()))
                .thenThrow(new RuntimeException("Test Exception"));

        try {
            priceController.search(PriceDto.builder().productId(35455).brandId(1).startDate("2020-06-14-10.00.00").build());
        } catch (Exception e) {
            assertEquals("Test Exception",e.getMessage());
            verify(priceServicePort, times(1)).getPrice(ArgumentMatchers.any(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
        }

    }

}
