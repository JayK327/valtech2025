package com.valtech.training.assignment.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.assignment.entities.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}
