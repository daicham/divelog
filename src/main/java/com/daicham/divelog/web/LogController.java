package com.daicham.divelog.web;

import com.daicham.divelog.domain.Log;
import com.daicham.divelog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String list(Model model) {
        model.addAttribute("logs", service.findAllOrderByNoDesc());
        return "logs/index";
    }

    @RequestMapping(path = "new", method = RequestMethod.GET)
    public String _new(Model model) {
        model.addAttribute("log", new Log());
        return "logs/new";
    }

    @RequestMapping(path = "new", method = RequestMethod.POST)
    public String register(@Valid Log log, BindingResult result) {
        if (result.hasErrors()) {
            return "logs/new";
        }
        service.register(log);
        return "redirect:/logs";
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("log", service.findById(id));
        return "logs/show";
    }

    @RequestMapping(path = "{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, Model model) {
        show(id, model);
        return "logs/edit";
    }

    @RequestMapping(path = "{id}", method = RequestMethod.POST)
    public String update(@Valid Log log, BindingResult result) {
        if (result.hasErrors()) {
            return "logs/edit";
        }
        service.update(log);
        return "redirect:/logs";
    }

    @RequestMapping(path = "{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/logs";
    }
}
