package com._poil.template.hello;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String hello() {
        return "Hello World";
    }
}
