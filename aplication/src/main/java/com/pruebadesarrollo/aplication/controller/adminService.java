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
	
	public Clientes obtenerCliente(Integer id) {
		return clientesreposito.findById(id).get();
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
	
	public void aumentarFrecuencia(Clientes cliente) {
		Integer frecuencia;
		frecuencia = cliente.getFrecuencia()+1;
		cliente.setFrecuencia(frecuencia);
		clientesreposito.save(cliente);
	}
	
	// METODOS PARA LOS TITULOS (JUEGOS)
	
	public List<Juegos> obtenerTodosJuegos() {
		return juegorepositorio.findAll();
	}
	
	public Juegos obtenerPorEdad(Integer op) {
		Clientes cliente = new Clientes();
		List<Integer> listaRellenar = new ArrayList<>();
		List<Alquiler> lista = new ArrayList<>();
		lista = alquilerrepositorio.findAll();
		for (Alquiler alquiler : lista) {
			cliente = clientesreposito.findById(alquiler.getAlquilador()).get();
			Integer edad = cliente.getEdad();
			switch (op) {
			case 1:
				if (edad > 0 && edad <= 10) {
					listaRellenar.add(alquiler.getIdJuego());
				}
				break;
			case 2:
				if (edad > 10 && edad <= 20) {
					listaRellenar.add(alquiler.getIdJuego());
				}
				break;
			case 3:
				if (edad > 20 && edad <= 30) {
					listaRellenar.add(alquiler.getIdJuego());
				}
				break;
			case 4:
				if (edad > 30 && edad <= 40) {
					listaRellenar.add(alquiler.getIdJuego());
				}
				break;
			case 5:
				if (edad > 40 && edad <= 50) {
					listaRellenar.add(alquiler.getIdJuego());
				}
				break;
			case 6:
				if (edad > 50 && edad <= 60) {
					listaRellenar.add(alquiler.getIdJuego());
				}
				break;
			case 7:
				if (edad > 60 && edad <= 70) {
					listaRellenar.add(alquiler.getIdJuego());
				}
				break;
			case 8:
				if (edad > 70 && edad <= 80) {
					listaRellenar.add(alquiler.getIdJuego());
				}
				break;
			case 9:
				if (edad > 80 && edad <= 90) {
					listaRellenar.add(alquiler.getIdJuego());
				}
				break;
			case 10:
				if (edad > 90 && edad <= 100) {
					listaRellenar.add(alquiler.getIdJuego());
				}
				break;
			default:
				break;
			}
		}
		
		Integer menosFrecuente = 0;
		Integer cont = 0, frecuencia = 10000;
		for (Integer str : listaRellenar) {
			for (Integer i = 1; i < listaRellenar.size(); i++) {
				if (listaRellenar.get(i).equals(str)) {
					cont++;
				}
			}
			if (cont <= frecuencia) {
				frecuencia = cont;
				menosFrecuente = str;
			}
			cont = 0;
		}
		
		try {
			return juegorepositorio.findById(menosFrecuente).get();
		} catch (Exception e) {
			
		}
		return (new Juegos());
	}
	
	public Juegos obtenerJuego(Integer id) {
		return juegorepositorio.findById(id).get();
	}
	
	public void guardarTitulo(Juegos juego) {
		juegorepositorio.save(juego);
	}
	
	public List<Juegos> obtenerPorDirector(String director) {
		List<Juegos> listaRellenar = new ArrayList<>();
		List<Juegos> lista = new ArrayList<>();
		lista = juegorepositorio.findAll();
		String comparador = new String();
		for (Juegos juego : lista) {
			director = director.toLowerCase();
			comparador = juego.getDirector().toLowerCase();
			if (comparador.contains(director)) {
				listaRellenar.add(juego);
			}
		}
		return listaRellenar;
	}
	
	public List<Juegos> obtenerPorProtagonista(String prota) {
		List<Juegos> listaRellenar = new ArrayList<>();
		List<Juegos> lista = new ArrayList<>();
		lista = juegorepositorio.findAll();
		String comparador = new String();
		for (Juegos juego : lista) {
			prota = prota.toLowerCase();
			comparador = juego.getProtagonista().toLowerCase();
			if (comparador.contains(prota)) {
				listaRellenar.add(juego);
			}
		}
		return listaRellenar;
	}
	
	public List<Juegos> obtenerPorProductor(String productor) {
		List<Juegos> listaRellenar = new ArrayList<>();
		List<Juegos> lista = new ArrayList<>();
		lista = juegorepositorio.findAll();
		String comparador = new String();
		for (Juegos juego : lista) {
			productor = productor.toLowerCase();
			comparador = juego.getProductor().toLowerCase();
			if (comparador.contains(productor)) {
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
	
	public Juegos actualizarTitulo(Juegos juego, Clientes cliente) {
		Integer frecuencia;
		frecuencia = juego.getFrecuencia()+1;
		juego.setFrecuencia(frecuencia);
		frecuencia = cliente.getFrecuencia()+1;
		cliente.setFrecuencia(frecuencia);
		registrarCompra(juego, cliente);
		clientesreposito.save(cliente);
		return juegorepositorio.save(juego);
	}
	
	// METODOS PARA LOS REGISTROS DE COMPRA
	
	public void registrarCompra(Juegos juego, Clientes cliente) {
		LocalDate hoy = LocalDate.now();
        LocalTime ahora = LocalTime.now();
        LocalDateTime fecha = LocalDateTime.of(hoy, ahora);
		Alquiler alquiler = new Alquiler();
		alquiler.setFecha(fecha.toString());
		alquiler.setNombre(juego.getTitulo());
		alquiler.setIdJuego(juego.getId());
		alquiler.setAlquilador(cliente.getId());
		alquiler.setFechaEntrega(fecha.plusDays(10).toString());
		alquilerrepositorio.save(alquiler);
	}
	
	public List<Alquiler> obtenerVentasDia(String hoy) {
		List<Alquiler> listaRellenar = new ArrayList<>();
		List<Alquiler> lista = new ArrayList<>();
		lista = alquilerrepositorio.findAll();
		for (Alquiler alquiler : lista) {
			if (alquiler.getFecha().contains(hoy)) {
				listaRellenar.add(alquiler);
			}
		}
		return listaRellenar;
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
