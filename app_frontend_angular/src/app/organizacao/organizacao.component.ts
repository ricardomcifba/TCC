import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

import { OrganizacaoService } from './organizacao.service';

@Component({
  selector: 'app-analise',
  templateUrl: './organizacao.component.html',
  styleUrls: ['./organizacao.component.css']
})
export class OrganizacaoComponent implements OnInit {

  listaOrganizacao: Array<any>;
  organizacao: any;

  constructor(private service: OrganizacaoService) {}

  ngOnInit() {
    this.organizacao = {};
    this.service.listar().subscribe(resposta => this.listaOrganizacao = resposta);
  }
 

}
