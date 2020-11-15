package com.pruebadesarrollo.aplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pruebadesarrollo.aplication.model.Juegos;
import com.pruebadesarrollo.aplication.model.Clientes;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class adminController {

	@Autowired
	private adminService service;
	
	// Para los clientes
	
	@GetMapping("cliente")
	public List<Clientes> obtener() {
		return service.obtenerTodosClientes();
	}
	
	@GetMapping("cliente/frecuente")
	public Clientes obtenerClienteMasFrecuente() {
		return service.obtenerClienteMasFrecuente();
	}
	
	@PostMapping("cliente")
	public Clientes guardarCliente(@RequestBody Clientes cliente) {
		service.guardarCliente(cliente);
		return cliente;
	}
	
	@PutMapping
	public Clientes actualizarCliente(@RequestBody Clientes cliente) {
		service.actualizarCliente(cliente);
		return cliente;
	}
	
	@DeleteMapping("cliente/{id}")
	public void eliminarCliente(@PathVariable("id") Integer id) {
		service.eliminarCliente(id);
	}
	
	// Para los titulos
	
	@GetMapping("titulo/frecuente")
	public Juegos obtenerTituloMasFrecuente() {
		return service.obtenerTituloMasFrecuente();
	}
	
	@PostMapping("titulo")
	public Juegos guardarTitulo(@RequestBody Juegos alquiler) {
		service.guardarTitulo(alquiler);
		return alquiler;
	}
	
	@DeleteMapping("titulo/{id}")
	public void eliminarTitulo(@PathVariable("id") Integer id) {
		service.eliminarTitulo(id);
	}
	
	@GetMapping("titulo/{id}")
	public void actualizarTitulo(@PathVariable("id") Integer id) {
		Juegos juego = new Juegos();
		juego = service.obtenerJuego(id);
		service.actualizarTitulo(juego);
	}
}
