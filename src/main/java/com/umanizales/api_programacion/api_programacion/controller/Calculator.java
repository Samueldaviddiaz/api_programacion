package com.umanizales.api_programacion.api_programacion.controller;

import com.umanizales.api_programacion.api_programacion.model.Kid;
import com.umanizales.api_programacion.api_programacion.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/calculator")

public class Calculator {
    @GetMapping(path = "/add/{num1}/{num2}")
    public int add(@PathVariable int num1,
                   @PathVariable int num2) {
        return num1 + num2;
    }

    @GetMapping(path = "/subs/{num1}/{num2}")
    public int subs(@PathVariable int num1,
                    @PathVariable int num2) {
        return num1 - num2;
    }

    @GetMapping(path = "/mult/{num1}/{num2}")
    public int mult(@PathVariable int num1,
                    @PathVariable int num2) {
        return num1 * num2;
    }

    @GetMapping(path = "/div/{num1}/{num2}")
    public int div(@PathVariable int num1,
                   @PathVariable int num2) {
        return num1 / num2;
    }

    @GetMapping(path = "/pot/{num1}/{num2}")
    public double pot(@PathVariable int num1,
                      @PathVariable int num2) {

        return Math.pow(num1, num2);
    }
}