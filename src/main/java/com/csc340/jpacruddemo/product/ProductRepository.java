package com.csc340.jpacruddemo.product;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sentini
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
