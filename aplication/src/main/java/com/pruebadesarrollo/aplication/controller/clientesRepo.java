package com.pruebadesarrollo.aplication.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebadesarrollo.aplication.model.Clientes;

@Repository
public interface clientesRepo extends JpaRepository<Clientes, Integer> {

}
