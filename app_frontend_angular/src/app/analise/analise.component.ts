import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

import { AnaliseService } from './analise.service';

@Component({
  selector: 'app-analise',
  templateUrl: './analise.component.html',
  styleUrls: ['./analise.component.css']
})
export class AnaliseComponent implements OnInit {

  listaAnalises: Array<any>;
  analise: any;

  constructor(private service: AnaliseService) {}

  ngOnInit() {
    this.analise = {};
    this.service.listar().subscribe(resposta => this.listaAnalises = resposta);
  }

}
