import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ServicioService } from '../servicio.service';
import { Titulos } from '../titulos';

@Component({
  selector: 'app-buscar-por-prota',
  templateUrl: './buscar-por-prota.component.html',
  styleUrls: ['./buscar-por-prota.component.css']
})
export class BuscarPorProtaComponent implements OnInit {

  prota:string = "";
  titulos:Titulos[] = [];

  constructor(private service:ServicioService, private router:Router,
    private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
  }

  buscar():void {
    this.service.buscarPorProta(this.prota).subscribe(ti => this.titulos = ti);
  }

}
