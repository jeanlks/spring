package com.jersey.rest.controller

import com.jersey.rest.model.Car
import com.jersey.rest.repository.CarRepository

import org.apache.log4j.Logger
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

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
}
