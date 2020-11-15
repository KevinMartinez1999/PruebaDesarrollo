package com.pruebadesarrollo.aplication.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebadesarrollo.aplication.model.Alquiler;

@Repository
public interface AlquilerRepo extends JpaRepository<Alquiler, Integer>{

}
