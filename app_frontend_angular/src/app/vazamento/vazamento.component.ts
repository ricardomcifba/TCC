import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

import { VazamentoService } from './vazamento.service';

@Component({
  selector: 'app-vazamento',
  templateUrl: './vazamento.component.html',
  styleUrls: ['./vazamento.component.css']
})
export class VazamentoComponent implements OnInit {

  listaVazamento: Array<any>;

  constructor(private service: VazamentoService) {}

  ngOnInit() {
    this.service.listar().subscribe(resposta => this.listaVazamento = resposta);
  }


}
