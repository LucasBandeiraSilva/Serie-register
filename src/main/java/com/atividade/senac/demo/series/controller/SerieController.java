package com.atividade.senac.demo.series.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.atividade.senac.demo.series.entity.Series;
import com.atividade.senac.demo.series.service.SeriesService;

import jakarta.validation.Valid;

@Controller
public class SerieController {

    @Autowired
    private SeriesService seriesService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/form")
    public ModelAndView showForm() {
        ModelAndView mv = new ModelAndView("form");
        mv.addObject("series", new Series());
        return mv;
    }

    @PostMapping("/submit")
    public ModelAndView saveSeries(@Valid @ModelAttribute Series series, BindingResult bindingResult) {
        return seriesService.saveSeries(series, bindingResult);
    }

    @GetMapping("/all")
    public ModelAndView allSeries() {
        return seriesService.listAllSeries();
    }
}
