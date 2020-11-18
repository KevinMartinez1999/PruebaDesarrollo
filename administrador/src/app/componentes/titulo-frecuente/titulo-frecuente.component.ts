import { Component, OnInit } from '@angular/core';
import { ServicioService } from '../servicio.service';
import { Titulos } from '../titulos';

@Component({
  selector: 'app-titulo-frecuente',
  templateUrl: './titulo-frecuente.component.html',
  styleUrls: ['./titulo-frecuente.component.css']
})
export class TituloFrecuenteComponent implements OnInit {

  juego:Titulos = new Titulos();

  constructor(private service:ServicioService) { }

  ngOnInit(): void {
    this.service.getTituloFrecuente().subscribe(es => this.juego=es);
  }

}
