package com.yuier.gamemall.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;

@Configuration
public class RabbitMQConfig {

    public final static String Direct_Order_Exchange = "direct_order_exchange";

    public final static String EMAIL = "yuier.email";

    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(RabbitMQConfig.Direct_Order_Exchange);
    }

    @Bean
    Queue queueEmail(){
        return new Queue("queueEmail");
    }

    @Bean
    Queue queueB(){
        return new Queue("queueB");
    }

    @Bean
    Queue queueC(){
        return new Queue("queueC");
    }

    @Bean
    Binding bindingExchangeA(Queue queueEmail,DirectExchange directExchange){
        return BindingBuilder.bind(queueEmail).to(directExchange).with(RabbitMQConfig.EMAIL);
    }

    @Bean
    Binding bindingExchangeB(Queue queueB,DirectExchange directExchange){
        return BindingBuilder.bind(queueB).to(directExchange).with("");
    }

    @Bean
    Binding bindingExchangeC(Queue queueC,DirectExchange directExchange){
        return BindingBuilder.bind(queueC).to(directExchange).with("");
    }

}
