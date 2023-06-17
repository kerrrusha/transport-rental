package com.kerrrusha.transportrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RentalLogController {

    @GetMapping({"/log", "/log/index", "/log/index.html"})
    public String index() {
        return "log/index";
    }

}
