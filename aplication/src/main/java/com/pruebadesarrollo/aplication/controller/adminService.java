package com.pruebadesarrollo.aplication.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.pruebadesarrollo.aplication.model.Juegos;
import com.pruebadesarrollo.aplication.model.Alquiler;
import com.pruebadesarrollo.aplication.model.Clientes;

@Service
public class adminService {

	@Autowired
	private clientesRepo clientesreposito;
	
	@Autowired
	private juegoRepo juegorepositorio;
	
	@Autowired
	private AlquilerRepo alquilerrepositorio;
	
	// Metodos para los clientes
	
	public List<Clientes> obtenerTodosClientes() {
		return clientesreposito.findAll();
	}
	
	public Clientes obtenerClienteMasFrecuente() {
		List<Clientes> lista = new ArrayList<>();
		lista = clientesreposito.findAll();
		Integer frecuencia = 0;
		Clientes c = new Clientes();
		for (Clientes cliente : lista) {
			if (cliente.getFrecuencia() > frecuencia) {
				frecuencia = cliente.getFrecuencia();
				c = cliente;
			}
		}
		return c;
	}
	
	public void guardarCliente(Clientes cliente) {
		clientesreposito.save(cliente);
	}
	
	public void eliminarCliente(Integer id) {
		clientesreposito.deleteById(id);
	}
	
	public void actualizarCliente(Clientes cliente) {
		clientesreposito.save(cliente);
	}
	
	// Metodos para los titulos
	
	public Juegos obtenerJuego(Integer id) {
		return juegorepositorio.findById(id).get();
	}
	
	public Juegos obtenerTituloMasFrecuente() {
		List<Juegos> lista = new ArrayList<>();
		lista = juegorepositorio.findAll();
		Integer frecuencia = 0;
		Juegos a = new Juegos();
		for (Juegos juego : lista) {
			if (juego.getFrecuencia() > frecuencia) {
				frecuencia = juego.getFrecuencia();
				a = juego;
			}
		}
		return a;
	}
	
	public void guardarTitulo(Juegos juego) {
		juegorepositorio.save(juego);
	}
	
	public void eliminarTitulo(Integer id) {
		juegorepositorio.deleteById(id);
	}
	
	public void actualizarTitulo(Juegos juego) {
		Integer frecuencia = juego.getFrecuencia()+1;
		juego.setFrecuencia(frecuencia);
		juegorepositorio.save(juego);
	}
	
	// Registar compras
	
	public void registrarAlquiler(@RequestBody Juegos juego) {
		Date fecha = new Date();
		Alquiler alquiler = new Alquiler();
		alquiler.setId(0);
		alquiler.setNombre(juego.getTitulo());
		alquiler.setFecha(fecha.toString());
		alquilerrepositorio.save(alquiler);
	}
	
}
