import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, ObservedValueOf } from 'rxjs';
import { ServicioService } from '../servicio.service';
import { Titulos } from '../titulos';

@Component({
  selector: 'app-menos-frecuente',
  templateUrl: './menos-frecuente.component.html',
  styleUrls: ['./menos-frecuente.component.css']
})
export class MenosFrecuenteComponent implements OnInit {

  op:number = 0;
  tl:Titulos = new Titulos;

  constructor(private service:ServicioService, private router:Router,
    private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
  }

  buscar():void {
    this.service.menosFrecuente(this.op).subscribe(e => this.tl = e);
  }
}
