package com.pruebadesarrollo.aplication.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pruebadesarrollo.aplication.model.Juegos;
import com.pruebadesarrollo.aplication.model.Alquiler;
import com.pruebadesarrollo.aplication.model.Clientes;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class adminController {

	@Autowired
	private adminService service;
	
	// PARA LOS CLIENTES
	
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
	
	@PutMapping("cliente")
	public Clientes actualizarCliente(@RequestBody Clientes cliente) {
		service.actualizarCliente(cliente);
		return cliente;
	}
	
	@GetMapping("cliente/{id}")
	public List<Alquiler> mostrarBalance(@PathVariable("id") Integer id) {
		return service.mostrarBalance(id);
	}
	
	// PARA LOS TITULOS
	
	@GetMapping("titulo")
	public List<Juegos> obtenerTodosJuegos() {
		return service.obtenerTodosJuegos();
	}
	
	@GetMapping("titulo/edad/{id}")
	public Juegos obtenerPorEdad(@PathVariable("id") Integer id) {
		return service.obtenerPorEdad(id);
	}
	
	@GetMapping("titulo/{id}")
	public Juegos obtenerJuego(@PathVariable("id") Integer id) {
		return service.obtenerJuego(id);
	}
	
	@GetMapping("titulo/frecuente")
	public Juegos obtenerTituloMasFrecuente() {
		return service.obtenerTituloMasFrecuente();
	}
	
	@PostMapping("titulo")
	public Juegos guardarTitulo(@RequestBody Juegos juego) {
		service.guardarTitulo(juego);
		return juego;
	}
	
	@PutMapping("titulo/modificar")
	public void modificarPrecio(@RequestBody Juegos juego) {
		service.guardarTitulo(juego);
	}
	
	@GetMapping("titulo/director/{director}")
	public List<Juegos> obtenerPorDirector(@PathVariable("director") String director) {
		return service.obtenerPorDirector(director);
	}
	
	@GetMapping("titulo/protagonista/{prota}")
	public List<Juegos> obtenerPorTipo(@PathVariable("prota") String prota) {
		return service.obtenerPorProtagonista(prota);
	}
	
	@GetMapping("titulo/productor/{productor}")
	public List<Juegos> obtenerPorTipoi(@PathVariable("productor") String productor) {
		return service.obtenerPorProductor(productor);
	}
	
	// PARA LAS VENTAS
	
	@GetMapping("ventas")
	public List<Alquiler> obtenerVentasDia() {
		LocalDate date = LocalDate.now();
		String hoy = date.toString();
		return service.obtenerVentasDia(hoy);
	}
	
	@GetMapping("ventas/{idPersona}/{idJuego}")
	public Juegos alquilar(@PathVariable("idPersona") Integer idPersona,
			@PathVariable("idJuego") Integer idJuego) {
		Juegos juego = new Juegos();
		Clientes cliente = new Clientes();
		juego = service.obtenerJuego(idJuego);
		cliente = service.obtenerCliente(idPersona);
		return service.actualizarTitulo(juego, cliente);
	}
}
