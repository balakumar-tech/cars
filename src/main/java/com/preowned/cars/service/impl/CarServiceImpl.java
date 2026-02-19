package com.preowned.cars.service.impl;

import com.preowned.cars.service.dto.Car;
import com.preowned.cars.service.dto.CarDTO;
import com.preowned.cars.service.ICarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceImpl implements ICarService {

    private CarRepository carRepository; //will be injected

    @Override
    public List<CarDTO> getAllCars() {
        return null;
    }

    @Override
    public CarDTO getCar(String regNo) {
        return null;
    }

    @Override
    public List<CarDTO> getAllCarsByBrandName(String brandName) {
        return null;
    }

    @Override
    public CarDTO addCar(Car car) {
        return null;
    }

    @Override
    public void updateCar(Car car) {

    }

    @Override
    public void deleteCar(String carRegNo) {

    }

    @Override
    public void deleteAllCars() {

    }
}
