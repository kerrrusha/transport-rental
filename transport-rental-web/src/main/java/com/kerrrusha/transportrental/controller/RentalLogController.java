package com.kerrrusha.transportrental.controller;

import com.kerrrusha.transportrental.service.RentalLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/log")
@RequiredArgsConstructor
public class RentalLogController {

    private final RentalLogService service;

    @GetMapping({"", "/", "/index", "/index.html"})
    public String index(Model model) {
        model.addAttribute("rentalLogs", service.findAll());
        return "log/index";
    }

}
