package com.jersey.rest.controller;

import com.jersey.rest.model.Car;
import com.jersey.rest.repository.CarRepository;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Jean on 7/21/17.
 */
@Controller
public class CarController {
    private CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @RequestMapping(value = "/car/list",method = RequestMethod.GET)
    public @ResponseBody  List<Car> listAll() {
        return (List<Car>) carRepository.findAll();
    }
}
