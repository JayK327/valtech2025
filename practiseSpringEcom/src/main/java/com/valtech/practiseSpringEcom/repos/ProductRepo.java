package com.valtech.practiseSpringEcom.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.practiseSpringEcom.models.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
