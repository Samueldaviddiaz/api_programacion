package com.umanizales.api_programacion.api_programacion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class ExampleController {
    @RestController
    @RequestMapping(path = "/calculator")

    public class Calculator {
        @GetMapping(path = "/kid")
        public int add(@PathVariable int num1,
                       @PathVariable int num2) {
            return num1 + num2;
        }
    }
}
