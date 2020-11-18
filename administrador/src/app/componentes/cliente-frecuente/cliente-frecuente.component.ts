import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ServicioService } from '../servicio.service';

@Component({
  selector: 'app-cliente-frecuente',
  templateUrl: './cliente-frecuente.component.html',
  styleUrls: ['./cliente-frecuente.component.css']
})
export class ClienteFrecuenteComponent implements OnInit {

  cliente:Cliente = new Cliente();

  constructor(private service:ServicioService) { }

  ngOnInit(): void {
    this.service.getOne().subscribe(es => this.cliente=es);
  }

}
