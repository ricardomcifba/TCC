 import { Component, OnInit } from '@angular/core';

import { FatoService } from './fato.service';

@Component({
  selector: 'app-fato',
  templateUrl: './fato.component.html',
  styleUrls: ['./fato.component.css']
})
export class FatoComponent implements OnInit {

  listaAnalises: Array<any>;


  constructor(private service: FatoService) {}

  ngOnInit() {
    this.service.listar().subscribe(resposta => 
      
      console.log(resposta)
      //{this.listaAnalises = resposta}
      );
  }

} 

/*

import { MdbTablePaginationComponent, MdbTableService } from 'angular-bootstrap-md';

import { Component, OnInit, ViewChild, HostListener, AfterViewInit, ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-fato',
  templateUrl: './fato.component.html',
  styleUrls: ['./fato.component.css']
})
export class FatoComponent implements OnInit, AfterViewInit {
  @ViewChild(MdbTablePaginationComponent) mdbTablePagination: MdbTablePaginationComponent;


  elements: any = [];
  previous: any = [];
  headElements = ['ID Fato', 'ID Organização', 'ID Serviço', 'ID Tempo', 'Total Registros','Perda m³','Perda Financeira'];

  firstItemIndex;
  lastItemIndex;

  constructor(private tableService: MdbTableService,
    private cdRef: ChangeDetectorRef) {
  }

  ngOnInit() {
    for (let i = 1; i <= 15; i++) {
      this.elements.push({ id: 'ID Fato', idOrganizacao: 'ID Organização', idServico: 'ID Serviço', idTempo: 'ID Tempo',
      total: 'Total Registros', perdaAgua: 'Perda m³' , perdaFinanceira: 'Perda Financeira' });
    }

    this.tableService.setDataSource(this.elements);
    this.elements = this.tableService.getDataSource();
    this.previous = this.tableService.getDataSource();
  }

  ngAfterViewInit() {
    this.mdbTablePagination.setMaxVisibleItemsNumberTo(5);
    this.firstItemIndex = this.mdbTablePagination.firstItemIndex;
    this.lastItemIndex = this.mdbTablePagination.lastItemIndex;

    this.mdbTablePagination.calculateFirstItemIndex();
    this.mdbTablePagination.calculateLastItemIndex();
    this.cdRef.detectChanges();
  }

  onNextPageClick(data: any) {
    this.firstItemIndex = data.first;
    this.lastItemIndex = data.last;
  }

  onPreviousPageClick(data: any) {
    this.firstItemIndex = data.first;
    this.lastItemIndex = data.last;
  }
}
*/

