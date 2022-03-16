package com.iudigital.rentacar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.rentacar.data.CarRepository;
import com.iudigital.rentacar.domain.Car;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	public void createCar(Car car) {
		carRepository.save(car);
	}
	
	public List<Car> getCars() {
		// select * from car;
		// select * from car where car_id = ?
		List<Car> cars = (List<Car>) carRepository.findAll();
		return cars;
	}
	 
}
