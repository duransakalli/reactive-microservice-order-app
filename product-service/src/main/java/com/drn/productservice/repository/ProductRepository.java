package com.drn.productservice.repository;

import com.drn.productservice.entity.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

    // > min & < max
    //    Flux<Product> findByPriceBetween(int min, int max);

    Flux<Product> findByPriceBetween(Range<Integer> range);

}
