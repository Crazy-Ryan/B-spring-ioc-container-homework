package com.thoughtworks.capability.demospringioccontainer;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(SCOPE_PROTOTYPE)
public class GreetingService {

    public GreetingService() {
        System.out.println("Creating an instance of GreetingService");
    }

    String sayHi() {
        return "hello world";
    }
}
