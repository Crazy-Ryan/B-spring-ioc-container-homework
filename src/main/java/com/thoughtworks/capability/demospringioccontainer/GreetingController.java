package com.thoughtworks.capability.demospringioccontainer;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(SCOPE_SINGLETON)
public class GreetingController implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        System.out.println("Creating an instance of Greeting Controller");
        this.greetingService = greetingService;
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @GetMapping("/greet")
    public String greet() {
        return applicationContext.getBean(GreetingService.class).sayHi();
    }

}
