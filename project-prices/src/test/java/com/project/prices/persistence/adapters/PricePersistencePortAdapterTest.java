package com.project.prices.persistence.adapters;

import com.project.prices.persistence.entities.PriceEntity;
import com.project.prices.persistence.repositories.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PricePersistencePortAdapterTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PricePersistencePortAdapter pricePersistencePortAdapter;

    @Test
    void findBySearch_SuccessResponse() {

        PriceEntity expected = PriceEntity.builder()
                .id(1L)
                .price(35.5)
                .priceList(1)
                .curr("EUR")
                .endDate(LocalDateTime.of(2020,12,31,23,59,59))
                .startDate(LocalDateTime.of(2020, 06,14,00,00,00))
                .brandId(1)
                .priority(0)
                .productId(35455)
                .build();

        when(priceRepository.findBySearch(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(), ArgumentMatchers.any()))
                .thenReturn(expected);

        PriceEntity response = pricePersistencePortAdapter.findBySearch(35455,1, LocalDateTime.of(2020,06,14,10,00,00));

        assertEquals(response, expected);
        verify(priceRepository, times(2)).findBySearch(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(), ArgumentMatchers.any());
    }

    @Test
    void findBySearch_ErrorWhenExceptionThrown() {

        when(priceRepository.findBySearch(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(), ArgumentMatchers.any()))
                .thenThrow(new RuntimeException("Test Exception"));

        try {
            pricePersistencePortAdapter.findBySearch(35455,1, LocalDateTime.of(2020,06,14,10,00,00));
        } catch (Exception e) {
            assertEquals("Test Exception",e.getMessage());
            verify(priceRepository, times(1)).findBySearch(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(), ArgumentMatchers.any());
        }

    }

}
