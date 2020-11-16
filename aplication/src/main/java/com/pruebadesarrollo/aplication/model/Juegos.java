
package com.pruebadesarrollo.aplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "juegos")
public class Juegos {

	@Id
	private Integer id;
	private String titulo;
	private Integer precio;
	private String director;
	private String protagonista;
	private String productor;
	private Integer frecuencia;
	
	public Juegos() {
		frecuencia = 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(Integer frecuencia) {
		this.frecuencia = frecuencia;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProtagonista() {
		return protagonista;
	}

	public void setProtagonista(String protagonista) {
		this.protagonista = protagonista;
	}

	public String getProductor() {
		return productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}
}
