package com.iudigital.rentacar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iudigital.rentacar.domain.Car;
import com.iudigital.rentacar.service.CarService;

@RestController
@RequestMapping("/car")
@CrossOrigin("*")
public class CarController {

	@Autowired
	private CarService carService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createCar(@RequestBody Car car) {
		carService.createCar(car);
	}
	
	@GetMapping
	public List<Car> getCars() {
		return carService.getCars();
	}
	
}
