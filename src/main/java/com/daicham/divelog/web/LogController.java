package com.daicham.divelog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author daicham
 */
@Controller
@RequestMapping("/logs")
public class LogController {
    @RequestMapping
    public String index(Model model) {
        model.addAttribute("message", "Hello World!");
        return "logs/index";
    }
}
