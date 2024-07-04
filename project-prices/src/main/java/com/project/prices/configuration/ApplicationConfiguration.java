package com.project.prices.configuration;

import com.project.prices.domain.ports.out.PricePersistencePort;
import com.project.prices.domain.ports.in.PriceServicePort;
import com.project.prices.domain.services.PriceServicePortImpl;
import com.project.prices.persistence.adapters.PricePersistencePortAdapter;
import com.project.prices.persistence.entities.PriceEntity;
import com.project.prices.persistence.repositories.PriceRepository;
import com.project.prices.rest.controller.PriceController;
import com.project.prices.rest.exception_handler.ApiExceptionHandler;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackageClasses = {ApiExceptionHandler.class})
@Configuration
@EntityScan(basePackageClasses = {PriceEntity.class})
@EnableJpaRepositories(basePackageClasses = { PriceRepository.class })
public class ApplicationConfiguration {

    @Bean
    public PriceServicePort priceService(PricePersistencePort pricePersistencePort) {
        return new PriceServicePortImpl(pricePersistencePort);
    }

    @Bean
    public PricePersistencePort pricePersistencePort(PriceRepository priceRepository) {
        return new PricePersistencePortAdapter(priceRepository);
    }

    @Bean
    public PriceController priceController(PriceServicePort priceServicePort) {
        return new PriceController(priceServicePort);
    }

}
