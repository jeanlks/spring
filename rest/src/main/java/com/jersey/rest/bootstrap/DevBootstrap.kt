package com.jersey.rest.bootstrap

import com.jersey.rest.model.Car
import com.jersey.rest.repository.CarRepository
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

/**
 * Created by Jean on 7/21/17.
 */
@Component
class DevBootstrap(private val carRepository: CarRepository) : ApplicationListener<ContextRefreshedEvent> {

    override fun onApplicationEvent(contextRefreshedEvent: ContextRefreshedEvent) {
        initData()
    }

    fun initData() {
//        val car = Car("Gol", "2000")
//        carRepository.save(car)
//
//        val car1 = Car("Celta", "2010")
//        carRepository.save(car1)
    }
}
