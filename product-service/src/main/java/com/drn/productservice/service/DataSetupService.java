package com.drn.productservice.service;

import com.drn.productservice.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DataSetupService implements CommandLineRunner {

    @Autowired
    private ProductService service;

    @Override
    public void run(String... args) throws Exception {
        ProductDto p1 = new ProductDto("monitor", 99.99);
        ProductDto p2 = new ProductDto("iphone", 999.99);
        ProductDto p3 = new ProductDto("camera", 549.99);
        ProductDto p4 = new ProductDto("camera XL", 749.99);
        ProductDto p5 = new ProductDto("imac", 1299.99);
        ProductDto p6 = new ProductDto("headphone", 19.99);

        Flux.just(p1,p2,p3,p4,p5,p6)
                .flatMap(p -> this.service.insertProduct(Mono.just(p)))
                .subscribe(System.out::println);
    }
}
