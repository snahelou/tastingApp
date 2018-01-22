package com.personnal.rhumrating.configuration;

import java.util.UUID;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.personnal.rhumrating.util.UuidBeanFactory;

@Configuration
public class SpringConfiguration {

    @Bean
    public static Mapper getMapper() {
        BeanMappingBuilder builder = new BeanMappingBuilder() {
            protected void configure() {
                mapping(UUID.class, UUID.class, TypeMappingOptions.oneWay(),
                        TypeMappingOptions.beanFactory(
                                UuidBeanFactory.class.getName()));
            }
        };

        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(builder);

        return mapper;
    }
}