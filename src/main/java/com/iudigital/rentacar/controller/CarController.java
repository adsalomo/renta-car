package com.iudigital.rentacar.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iudigital.rentacar.controller.converter.CarConverter;
import com.iudigital.rentacar.controller.dto.CarDTO;
import com.iudigital.rentacar.service.CarService;

@RestController
@RequestMapping("/car")
@CrossOrigin("*")
public class CarController {

	@Autowired
	private CarService carService;
	@Autowired
	private CarConverter carConverter;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createCar(@RequestBody CarDTO carDTO) {
		carService.createCar(carConverter.convertCarDTOToCar(carDTO));
	}
	
	@GetMapping
	public List<CarDTO> getCars() {
		return carService.getCars()
				.stream()
				.map(car -> carConverter.convertCarToCarDTO(car))
				.collect(Collectors.toList());
		
//		List<CarDTO> carDTOs = new ArrayList<>();
//		
//		for (Car car : carService.getCars()) {
//			carDTOs.add(carConverter.convertCarToCarDTO(car));
//		}
//		
//		return carDTOs;
	}
	
	// api/brand/nissan/color/rojo
	@GetMapping("/brand/{brand}/color/{color}")
	public List<CarDTO> getCarsByBrandAndColor(@PathVariable String brand, @PathVariable String color) {
		return carService.getCarsByBrandAndColor(brand, color)
				.stream()
				.map(car -> carConverter.convertCarToCarDTO(car))
				.collect(Collectors.toList());
	}
	
	
	@GetMapping("/brand/{brand}")
	public List<CarDTO> getCarsByBrand(@PathVariable String brand) {
		return carService.getCarsByBrand(brand)
				.stream()
				.map(car -> carConverter.convertCarToCarDTO(car))
				.collect(Collectors.toList());
	}
	
}
