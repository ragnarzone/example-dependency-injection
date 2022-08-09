package com.ragnarzone.exampledependencyinjection.config;

import com.ragnarzone.exampledependencyinjection.repositories.EnglishGreetingRepository;
import com.ragnarzone.exampledependencyinjection.repositories.EnglishGreetingRepositoryImpl;
import com.ragnarzone.exampledependencyinjection.services.*;
import com.springframework.pets.CatPetService;
import com.springframework.pets.DogPetService;
import org.springframework.context.annotation.*;

@ComponentScan(basePackages = {"com.springframework.pets"})
@Configuration
public class GreetingServiceConfig {

    @Bean("dogPetService")
    DogPetService dogPetService() {
        return new DogPetService();
    }

    @Bean("catPetService")
    CatPetService catPetService() {
        return new CatPetService();
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService() {
        return new I18nSpanishGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }
}
