package com.iudigital.rentacar.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.rentacar.domain.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

	// select * from car where color = 'blanco'
	// select * from car where color = 'negro'
	public List<Car> findByColor(String color);
	
	// select * from car where brand = 'nissan'
	public List<Car> findByBrand(String brand);
	
	// select * from car where brand = 'nissan' and color = 'negro'
	public List<Car> findByBrandAndColor(String brand, String color);
	
	List<Car> findDistinctByBrandAndModel(String brand, String model);
	
	//@Query("select * from Car c where c.color = ?1") // jpql
	//@Query(value = "select * from car c where c.color = ?1", nativeQuery = true) // sql nativo
	//List<Car> getCarsByColor(String color);
	
}
