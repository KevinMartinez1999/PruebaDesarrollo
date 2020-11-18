import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from '../cliente';
import { ServicioService } from '../servicio.service';

@Component({
  selector: 'app-agregar-cliente',
  templateUrl: './agregar-cliente.component.html',
  styleUrls: ['./agregar-cliente.component.css']
})
export class AgregarClienteComponent implements OnInit {

  es:Cliente = new Cliente();

  constructor(private service:ServicioService, private router:Router,
    private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
  }

  create():void {
    this.service.create(this.es).subscribe(res => this.router.navigate(['']));
  }

  update():void {
    this.service.update(this.es).subscribe(e => this.router.navigate(['']));
  }

}
