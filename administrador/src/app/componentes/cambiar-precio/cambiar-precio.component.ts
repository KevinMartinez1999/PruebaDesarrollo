import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Alquiler } from '../alquiler';
import { Cliente } from '../cliente';
import { ServicioService } from '../servicio.service';
import { TituloFrecuenteComponent } from '../titulo-frecuente/titulo-frecuente.component';
import { Titulos } from '../titulos';

@Component({
  selector: 'app-cambiar-precio',
  templateUrl: './cambiar-precio.component.html',
  styleUrls: ['./cambiar-precio.component.css']
})
export class CambiarPrecioComponent implements OnInit {

  per:number = 0;
  id:number = 0;
  titulos:Titulos = new Titulos;

  constructor(private service:ServicioService, private router:Router,
    private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(e => this.id = e['id']);
    this.service.obtenerOne(this.id).subscribe(tl => this.titulos = tl);
  }

  modificar():void {
    this.service.modificarPrecio(this.titulos).subscribe(e => this.router.navigate(['']));
  }

}
