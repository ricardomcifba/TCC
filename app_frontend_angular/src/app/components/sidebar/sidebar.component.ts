import { Component, OnInit } from '@angular/core';

declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
    //{ path: '/analise', title: 'Análise',  icon:'files_paper', class: '' },
    { path: '/fato', title: 'Tabela Fato',  icon:'files_paper', class: '' },
    { path: '/perdas', title: 'Gráfico de Perdas',  icon: 'design_app', class: '' },
    { path: '/setor', title: 'Perdas por Setor',  icon:'files_paper', class: '' },
    { path: '/bairro', title: 'Perdas por Bairro',  icon:'files_paper', class: '' },
    { path: '/organizacao', title: 'Dimensao Organização',  icon:'files_paper', class: '' },
    { path: '/vazamento', title: 'Registros de Vazamento',  icon:'files_paper', class: '' },
    { path: '/maps', title: 'Mapa',  icon:'location_map-big', class: '' },
    //{ path: '/mapa', title: 'Mapa',  icon:'files_paper', class: '' }

];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
      if ( window.innerWidth > 991) {
          return false;
      }
      return true;
  };
}
