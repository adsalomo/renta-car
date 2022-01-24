package com.iudigital.rentacar.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.rentacar.domain.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

}
