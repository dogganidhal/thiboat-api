package com.ndogga.cfa.thiboat.configuration;


import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author nidhaldogga
 * @created 16/02/2021 10:14
 * SoftKall™ All rights reserved.
 */


@Configuration
public class ApplicationConfiguration {

  @Bean
  public OpenAPI openApi() {
    return new OpenAPI();
  }

}
