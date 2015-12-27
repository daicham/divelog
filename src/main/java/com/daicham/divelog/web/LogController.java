package com.daicham.divelog.web;

import com.daicham.divelog.domain.Log;
import com.daicham.divelog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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

    @RequestMapping(path = "new", method = RequestMethod.GET)
    public String _new() {
        return "logs/new";
    }

    @RequestMapping(path = "new", method = RequestMethod.POST)
    public String register(@Valid Log log) {
        service.register(log);
        return "redirect:/logs";
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("log", service.findById(id));
        return "logs/show";
    }
}
