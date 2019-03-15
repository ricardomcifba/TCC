import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
export var ROUTES = [
    { path: '/analise', title: 'Análise', icon: 'files_paper', class: '' },
    { path: '/maps', title: 'Maps', icon: 'location_map-big', class: '' },
    { path: '/dashboard', title: 'Gráfico de Perdas', icon: 'design_app', class: '' },
    { path: '/organizacao', title: 'Dimensao Organização', icon: 'files_paper', class: '' },
    { path: '/vazamento', title: 'Registros de Vazamento', icon: 'files_paper', class: '' }
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