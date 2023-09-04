package com.challenge.transfer.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class MainConfig {

    //TODO if not needed remove dependency as well
    /*@Primary
    @Bean
    public Gson gson() {
        return GsonFac
    }*/

    @Bean
    public RestOperations restTemplate(GsonHttpMessageConverter gsonHttpMessageConverter) {
        final RestTemplate template
                = new RestTemplate(Collections.singletonList(gsonHttpMessageConverter));
        return template;
    }
}
