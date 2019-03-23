import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
export var ROUTES = [
    //{ path: '/analise', title: 'Análise',  icon:'files_paper', class: '' },
    { path: '/fato', title: 'Tabela Fato', icon: 'files_paper', class: '' },
    { path: '/perdas', title: 'Gráfico de Perdas', icon: 'design_app', class: '' },
    { path: '/setor', title: 'Perdas por Setor', icon: 'files_paper', class: '' },
    { path: '/bairro', title: 'Perdas por Bairro', icon: 'files_paper', class: '' },
    { path: '/organizacao', title: 'Dimensao Organização', icon: 'files_paper', class: '' },
    { path: '/vazamento', title: 'Registros de Vazamento', icon: 'files_paper', class: '' },
    { path: '/mapa', title: 'Mapa', icon: 'files_paper', class: '' }
];
var SidebarComponent = /** @class */ (function () {
    function SidebarComponent() {
    }
    SidebarComponent.prototype.ngOnInit = function () {
        this.menuItems = ROUTES.filter(function (menuItem) { return menuItem; });
    };
    SidebarComponent.prototype.isMobileMenu = function () {
        if (window.innerWidth > 991) {
            return false;
        }
        return true;
    };
    ;
    SidebarComponent = tslib_1.__decorate([
        Component({
            selector: 'app-sidebar',
            templateUrl: './sidebar.component.html',
            styleUrls: ['./sidebar.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [])
    ], SidebarComponent);
    return SidebarComponent;
}());
export { SidebarComponent };
//# sourceMappingURL=sidebar.component.js.map