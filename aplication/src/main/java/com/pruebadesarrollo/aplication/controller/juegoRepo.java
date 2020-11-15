package com.pruebadesarrollo.aplication.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebadesarrollo.aplication.model.Juegos;

@Repository
public interface juegoRepo extends JpaRepository<Juegos, Integer> {

}
