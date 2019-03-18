import { Component, OnInit } from '@angular/core';

import { FatoService } from './fato.service';

@Component({
  selector: 'app-fato',
  templateUrl: './fato.component.html',
  styleUrls: ['./fato.component.css']
})
export class FatoComponent implements OnInit {

  listaFato: Array<any>;
  analise: any;

  constructor(private service: FatoService) {}

  ngOnInit() {
    this.analise = {};
    this.service.listar().subscribe(resposta => this.listaFato = resposta);
  }

}
