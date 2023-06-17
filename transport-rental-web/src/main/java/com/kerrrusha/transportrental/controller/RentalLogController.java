package com.kerrrusha.transportrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/log")
public class RentalLogController {

    @GetMapping({"", "/", "/index", "/index.html"})
    public String index() {
        return "log/index";
    }

}
