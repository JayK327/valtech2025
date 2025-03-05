package com.valtech.training.restapis.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.restapis.entities.Owner;

@Repository
public interface OwnerRepo extends JpaRepository<Owner, Long> {

	List<Owner> findAllByName(String name);

}
