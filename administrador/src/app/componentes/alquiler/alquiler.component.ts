import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Alquiler } from '../alquiler';
import { ServicioService } from '../servicio.service';
import { Titulos } from '../titulos';

@Component({
  selector: 'app-alquiler',
  templateUrl: './alquiler.component.html',
  styleUrls: ['./alquiler.component.css']
})
export class AlquilerComponent implements OnInit {

  idPersona:number = 0;
  idJuego:number = 0;

  constructor(private service:ServicioService, private router:Router,
    private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
  }

  create():void {
    this.service.alquilar(this.idPersona, this.idJuego).subscribe(res => this.router.navigate(['']));
  }

}
