package com.jersey.rest.controller;

import com.jersey.rest.model.Car;
import com.jersey.rest.repository.CarRepository;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Jean on 7/21/17.
 */
@Controller
public class CarController {
    private CarRepository carRepository;
    private Logger logger = Logger.getLogger(CarController.class);
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @RequestMapping(value = "/car/list",method = RequestMethod.GET)
    public @ResponseBody  List<Car> listAll(HttpServletRequest request) {

        logger.info("Retornando lista de carros, ip: "+ request.getRemoteAddr());

        return (List<Car>) carRepository.findAll();

    }
}
