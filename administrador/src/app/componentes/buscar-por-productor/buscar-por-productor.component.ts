import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ServicioService } from '../servicio.service';
import { Titulos } from '../titulos';

@Component({
  selector: 'app-buscar-por-productor',
  templateUrl: './buscar-por-productor.component.html',
  styleUrls: ['./buscar-por-productor.component.css']
})
export class BuscarPorProductorComponent implements OnInit {

  productor:string = "";
  titulos:Titulos[] = [];

  constructor(private service:ServicioService, private router:Router,
    private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
  }

  buscar():void {
    this.service.buscarPorProductor(this.productor).subscribe(ti => this.titulos = ti);
  }

}
