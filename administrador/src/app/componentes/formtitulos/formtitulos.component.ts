import { Component, OnInit } from '@angular/core';
import { ServicioService } from '../servicio.service';
import { Titulos } from '../titulos';

@Component({
  selector: 'app-formtitulos',
  templateUrl: './formtitulos.component.html',
  styleUrls: ['./formtitulos.component.css']
})
export class FormtitulosComponent implements OnInit {

  titulos:Titulos[] = [];

  constructor(private service:ServicioService) { }

  ngOnInit(): void {
    this.service.getAllTitulos().subscribe(ti => this.titulos = ti);
  }

}
