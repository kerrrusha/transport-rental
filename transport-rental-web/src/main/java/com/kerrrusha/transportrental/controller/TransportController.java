package com.kerrrusha.transportrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransportController {

    @GetMapping({"/transport", "/transport/index", "/transport/index.html"})
    public String index() {
        return "transport/index";
    }

}
