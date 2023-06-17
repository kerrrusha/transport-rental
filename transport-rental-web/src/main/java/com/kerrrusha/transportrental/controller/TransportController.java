package com.kerrrusha.transportrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transport")
public class TransportController {

    @GetMapping({"", "/", "/index", "/index.html"})
    public String index() {
        return "transport/index";
    }

}
