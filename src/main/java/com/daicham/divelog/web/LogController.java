package com.daicham.divelog.web;

import com.daicham.divelog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author daicham
 */
@Controller
@RequestMapping("/logs")
public class LogController {
    @Autowired
    private LogService service;

    @RequestMapping
    public String index(Model model) {
        model.addAttribute("logs", service.findAll());
        return "logs/index";
    }
}
