package com.demo.kafka.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        MessageProducer producer = context.getBean(MessageProducer.class);
        producer.sendMessageToOutput("Sending message through spring project");
        producer.sendGreeting(new Greeting("jean", "hello message!"));
    }

    @Bean
    public MessageProducer getProducer() {
        return new MessageProducer();
    }
}
