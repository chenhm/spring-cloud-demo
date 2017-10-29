package com.example;


import java.util.Arrays;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        name = "reservation-service", fallback = NamesFeignClient.NamesFeignClientFallback.class
)
public interface NamesFeignClient {
    @RequestMapping(value = "/reservations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    Resources<Reservation> reservations();

    @Component
    class NamesFeignClientFallback implements NamesFeignClient {

        @Override
        public Resources<Reservation> reservations() {
            return new Resources(Arrays.asList(new Reservation(1L, "Frank")));
        }
    }
}

