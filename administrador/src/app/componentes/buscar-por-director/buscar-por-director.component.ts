import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ServicioService } from '../servicio.service';
import { Titulos } from '../titulos';

@Component({
  selector: 'app-buscar-por-director',
  templateUrl: './buscar-por-director.component.html',
  styleUrls: ['./buscar-por-director.component.css']
})
export class BuscarPorDirectorComponent implements OnInit {

  director:string = "";
  titulos:Titulos[] = [];

  constructor(private service:ServicioService, private router:Router,
    private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
  }

  buscar():void {
    this.service.buscarPorDirector(this.director).subscribe(ti => this.titulos = ti);
  }

}
