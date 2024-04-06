package org.spring.customermanagementapplication.customermanagementapplication.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping(value = "/api")
    public String show() {
        return "Hello World";
    }
}
