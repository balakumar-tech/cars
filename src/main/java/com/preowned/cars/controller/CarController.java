package com.preowned.cars.controller;

import com.preowned.cars.service.dto.Car;
import com.preowned.cars.service.dto.CarDTO;
import com.preowned.cars.service.ICarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path="/cars", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CarController {

    private ICarService iCarService;

    @GetMapping
    public List<CarDTO> getAllCars() {
        return iCarService.getAllCars();
    }

    @PostMapping
    public ResponseEntity<CarDTO> addCar(@RequestBody Car car, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println("XXX car is"+car);
        CarDTO carDto = iCarService.addCar(car);

        URI locationURI = uriComponentsBuilder.path("cars/"+carDto.getRegNo())
                .buildAndExpand(uriComponentsBuilder.toUriString())
                .toUri();

        return ResponseEntity.status(HttpStatus.CREATED)
                .location(locationURI)
                .body(carDto);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllCars() {

        iCarService.deleteAllCars();
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

    @PutMapping
    public ResponseEntity<String> putNotSupported() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .build();
    }

    @GetMapping("/{carRegNo")
    public ResponseEntity<CarDTO> getCar(@PathVariable String carRegNo) {

        CarDTO carDto = iCarService.getCar(carRegNo);
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }

    @PostMapping
    public ResponseEntity<String> postNotSupported() {

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .build();
    }

    @PutMapping("/{carRegNo")
    public ResponseEntity<CarDTO> updateCar(@PathVariable String carRegNo, @RequestBody Car car,
                                            UriComponentsBuilder uriComponentsBuilder) {
        iCarService.updateCar(car);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

    @DeleteMapping("/{carRegNo")
    public ResponseEntity<String> deleteCarDetails(@PathVariable String carRegNo) {
        iCarService.deleteCar(carRegNo);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }
}
