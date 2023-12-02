package com.atividade.senac.demo.series.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.atividade.senac.demo.series.entity.Series;
import com.atividade.senac.demo.series.repository.SeriesRepository;

@Service
public class SeriesService {

    @Autowired
    private SeriesRepository serieRepository;

    public ModelAndView saveSeries(@ModelAttribute Series series, BindingResult result) {
        ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {
            return new ModelAndView("form");
        }
        this.serieRepository.save(series);
        mv.setViewName("registered-series");
        return mv;
    }

    public ModelAndView listAllSeries() {
        ModelAndView mv = new ModelAndView();
        List<Series> serieList = this.serieRepository.findAll();
        if (serieList.size() == 0) {
            return new ModelAndView("empty-list");
        }
        mv.setViewName("all-series");
        mv.addObject("seriesList", serieList);
        return mv;
    }
}
