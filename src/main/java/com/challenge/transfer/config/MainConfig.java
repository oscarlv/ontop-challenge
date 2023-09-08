package com.challenge.transfer.config;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;


@Configuration
public class MainConfig {

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                //.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter(Gson gson) {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(gson);
        return converter;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder, GsonHttpMessageConverter gsonHttpMessageConverter) {
        return restTemplateBuilder
                .additionalMessageConverters(gsonHttpMessageConverter)
                .build();
    }
}
