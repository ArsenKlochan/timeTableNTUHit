package com.ntu.api;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLConfiguration {
    public static void main(String[] args) {
        ApplicationContext contex =
                new ClassPathXmlApplicationContext(
                        "com/ntu/api/spring/spring-config.xml");
    }
}
