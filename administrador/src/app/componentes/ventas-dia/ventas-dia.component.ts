import { Component, OnInit } from '@angular/core';
import { Alquiler } from '../alquiler';
import { ServicioService } from '../servicio.service';

@Component({
  selector: 'app-ventas-dia',
  templateUrl: './ventas-dia.component.html',
  styleUrls: ['./ventas-dia.component.css']
})
export class VentasDiaComponent implements OnInit {

  alquiler:Alquiler[] = [];

  constructor(private service:ServicioService) { }

  ngOnInit(): void {
    this.service.obtenerVentas().subscribe(al => this.alquiler = al);
  }

}
