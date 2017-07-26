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
import javax.websocket.server.PathParam

/**
 * Created by Jean on 7/21/17.
 */
@Controller
@RequestMapping("/car")
class CarController(private val carRepository: CarRepository) {
    private val logger = Logger.getLogger(CarController::class.java!!)

    @GetMapping(value = "/list")
    @ResponseBody
    fun listAll(request: HttpServletRequest): List<Car> {

        logger.info("Retornando lista de carros, ip: " + request.remoteAddr)

        return carRepository.findAll() as List<Car>

    }

    @PostMapping(consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ResponseBody
    fun addCar(@RequestBody car:Car, request:HttpServletRequest ): ResponseEntity<Car> {
        logger.info("Adicionando carro, ip: " + request.remoteAddr)

        return  ResponseEntity<Car>(carRepository.save(car), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    fun deleteCar(@PathVariable id: Long, request:HttpServletRequest ): String {
        logger.info("Deletando carro, ip: " + request.remoteAddr)
        carRepository.delete(id)
        return  ("Sucesso")
    }

}
