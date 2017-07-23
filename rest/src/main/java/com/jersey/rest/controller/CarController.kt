package com.jersey.rest.controller

import com.jersey.rest.model.Car
import com.jersey.rest.repository.CarRepository

import org.apache.log4j.Logger
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

import javax.servlet.http.HttpServletRequest

/**
 * Created by Jean on 7/21/17.
 */
@Controller
class CarController(private val carRepository: CarRepository) {
    private val logger = Logger.getLogger(CarController::class.java!!)

    @RequestMapping(value = "/car/list", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun listAll(request: HttpServletRequest): List<Car> {

        logger.info("Retornando lista de carros, ip: " + request.remoteAddr)

        return carRepository.findAll() as List<Car>

    }

    @RequestMapping(value = "/car/add",method = arrayOf(RequestMethod.POST),
                                       consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ResponseBody
    fun addCar(@RequestBody car:Car, request:HttpServletRequest ): ResponseEntity<Car> {
        logger.info("Adicionando carro, ip: " + request.remoteAddr)

        return  ResponseEntity<Car>(carRepository.save(car), HttpStatus.OK);
    }
}
