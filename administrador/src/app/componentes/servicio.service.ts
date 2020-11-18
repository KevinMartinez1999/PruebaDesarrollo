import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Alquiler } from './alquiler';
import { Cliente } from './cliente';
import { Titulos } from './titulos';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {
  private url:string = "http://localhost:8080";
  private op:number = 0;

  constructor(private http:HttpClient) { }

  getOne():Observable<Cliente> {
    return this.http.get<Cliente>(this.url+'/cliente/frecuente');
  }

  getAll():Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.url+'/cliente');
  }

  create(es:Cliente):Observable<Cliente> {
    return this.http.post<Cliente>(this.url+'/cliente', es);
  }

  update(es:Cliente):Observable<Cliente> {
    return this.http.put<Cliente>(this.url+'/cliente', es);
  }

  //Para los titulos

  getTituloFrecuente():Observable<Titulos> {
    return this.http.get<Titulos>(this.url+'/titulo/frecuente')
  }

  getAllTitulos():Observable<Titulos[]> {
    return this.http.get<Titulos[]>(this.url+'/titulo');
  }

  buscarPorDirector(director:string):Observable<Titulos[]> {
    if (director == ""){
      return this.http.get<Titulos[]>(this.url+'/titulo');
    }
    else {
      return this.http.get<Titulos[]>(this.url+'/titulo/director/'+director);
    }
  }

  buscarPorProta(prota:string):Observable<Titulos[]> {
    if (prota == ""){
      return this.http.get<Titulos[]>(this.url+'/titulo');
    }
    else {
      return this.http.get<Titulos[]>(this.url+'/titulo/protagonista/'+prota);
    }
  }

  buscarPorProductor(productor:string):Observable<Titulos[]> {
    if (productor == ""){
      return this.http.get<Titulos[]>(this.url+'/titulo');
    }
    else {
      return this.http.get<Titulos[]>(this.url+'/titulo/productor/'+productor);
    }
  }

  //Para las ventas

  alquilar(idPersona:number, idJuego:number):Observable<Titulos> {
    return this.http.get<Titulos>(this.url+'/ventas/'+idPersona+'/'+idJuego);
  }

  obtenerVentas():Observable<Alquiler[]> {
    return this.http.get<Alquiler[]>(this.url+'/ventas');
  }
}
