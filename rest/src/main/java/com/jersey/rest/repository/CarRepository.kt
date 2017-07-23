package com.jersey.rest.repository

import com.jersey.rest.model.Car
import org.springframework.data.repository.CrudRepository

/**
 * Created by Jean on 7/21/17.
 */
interface CarRepository : CrudRepository<Car, Long>
