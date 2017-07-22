package com.jersey.rest.bootstrap;

import com.jersey.rest.model.Car;
import com.jersey.rest.repository.CarRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Jean on 7/21/17.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private CarRepository carRepository;

    public DevBootstrap(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData(){
        Car car = new Car("Gol","2000");
        carRepository.save(car);

        Car car1 = new Car("Celta","2010");
        carRepository.save(car1);
    }
}
