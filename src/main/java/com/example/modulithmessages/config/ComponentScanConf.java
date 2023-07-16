package com.example.modulithmessages.config;

import io.craftgate.modulith.messaging.api.annotation.DomainComponent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = {
                "com.example.modulithmessages",
                "io.craftgate.modulith.messaging.api",
        },
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        value = {DomainComponent.class}
                )
        }
)
public class ComponentScanConf {


}
