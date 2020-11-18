import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ServicioService } from '../servicio.service';

@Component({
  selector: 'app-formclientes',
  templateUrl: './formclientes.component.html',
  styleUrls: ['./formclientes.component.css']
})
export class FormclientesComponent implements OnInit {

  clientes:Cliente[] = [];

  constructor(private service:ServicioService) { }

  ngOnInit(): void {
    this.service.getAll().subscribe(es => this.clientes=es);
  }
}
