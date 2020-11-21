import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Alquiler } from '../alquiler';
import { ServicioService } from '../servicio.service';

@Component({
  selector: 'app-balance',
  templateUrl: './balance.component.html',
  styleUrls: ['./balance.component.css']
})
export class BalanceComponent implements OnInit {

  per:number = 0;
  alquiler:Alquiler[] = [];

  constructor(private service:ServicioService, private router:Router,
    private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
  }

  buscar():void {
    this.service.obtenerBalance(this.per).subscribe(e => this.alquiler = e);
  }

}
