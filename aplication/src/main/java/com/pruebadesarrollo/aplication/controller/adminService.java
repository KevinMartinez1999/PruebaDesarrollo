package com.pruebadesarrollo.aplication.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	// METODOS PARA LOS CLIENTES
	
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
	
	// METODOS PARA LOS TITULOS (JUEGOS)
	
	public Juegos obtenerJuego(Integer id) {
		return juegorepositorio.findById(id).get();
	}
	
	public List<Juegos> obtenerPorDirector(String director) {
		List<Juegos> listaRellenar = new ArrayList<>();
		List<Juegos> lista = new ArrayList<>();
		lista = juegorepositorio.findAll();
		for (Juegos juego : lista) {
			if (director.equalsIgnoreCase(juego.getDirector())) {
				listaRellenar.add(juego);
			}
		}
		return listaRellenar;
	}
	
	public List<Juegos> obtenerPorProtagonista(String prota) {
		List<Juegos> listaRellenar = new ArrayList<>();
		List<Juegos> lista = new ArrayList<>();
		lista = juegorepositorio.findAll();
		for (Juegos juego : lista) {
			if (prota.equalsIgnoreCase(juego.getProtagonista())) {
				listaRellenar.add(juego);
			}
		}
		return listaRellenar;
	}
	
	public List<Juegos> obtenerPorProductor(String productor) {
		List<Juegos> listaRellenar = new ArrayList<>();
		List<Juegos> lista = new ArrayList<>();
		lista = juegorepositorio.findAll();
		for (Juegos juego : lista) {
			if (productor.equalsIgnoreCase(juego.getProductor())) {
				listaRellenar.add(juego);
			}
		}
		return listaRellenar;
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
		Integer frecuencia;
		frecuencia = juego.getFrecuencia()+1;
		juego.setFrecuencia(frecuencia);
		juegorepositorio.save(juego);
	}
	
	// METODOS PARA LOS REGISTROS DE COMPRA
	
	public void registrarCompra(Juegos juego) {
		LocalDate hoy = LocalDate.now();
        LocalTime ahora = LocalTime.now();
        LocalDateTime fecha = LocalDateTime.of(hoy, ahora);
		Alquiler alquiler = new Alquiler();
		alquiler.setFecha(fecha.toString());
		alquiler.setNombre(juego.getTitulo());
		alquiler.setAlquilador(juego.getId());
		alquiler.setFechaEntrega(fecha.plusDays(10).toString());
		alquilerrepositorio.save(alquiler);
	}
	
	public List<Alquiler> obtenerVentasDia(String hoy) {
		List<Alquiler> listaRellenar = new ArrayList<>();
		List<Alquiler> lista = new ArrayList<>();
		lista = alquilerrepositorio.findAll();
		for (Alquiler alquiler : lista) {
			if (hoy.equalsIgnoreCase(alquiler.getFecha())) {
				listaRellenar.add(alquiler);
			}
		}
		return lista;
	}
	
	public List<Alquiler> mostrarBalance(Integer id) {
		List<Alquiler> listaRellenar = new ArrayList<>();
		List<Alquiler> lista = new ArrayList<>();
		lista = alquilerrepositorio.findAll();
		for (Alquiler alquiler : lista) {
			if (id.equals(alquiler.getAlquilador())) {
				listaRellenar.add(alquiler);
			}
		}
		return listaRellenar;
	}
}
