package com.preowned.cars.service;

import com.preowned.cars.service.dto.Car;
import com.preowned.cars.service.dto.CarDTO;

import java.util.List;

public interface ICarService {

    //GET
    public List<CarDTO> getAllCars();
    public CarDTO getCar(String regNo);
    public List<CarDTO> getAllCarsByBrandName(String brandName);

    //POST
    public CarDTO addCar(Car car);

    //PUT
    public void updateCar(Car car);

    //DELETE
    public void deleteCar(String carRegNo);
    public void deleteAllCars();
}
