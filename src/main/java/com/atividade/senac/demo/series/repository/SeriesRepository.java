package com.atividade.senac.demo.series.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade.senac.demo.series.entity.Series;

public interface SeriesRepository extends JpaRepository<Series,Long> {
    
}
