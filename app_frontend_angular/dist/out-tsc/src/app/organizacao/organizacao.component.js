import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { OrganizacaoService } from './organizacao.service';
var OrganizacaoComponent = /** @class */ (function () {
    function OrganizacaoComponent(service) {
        this.service = service;
    }
    OrganizacaoComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.organizacao = {};
        this.service.listar().subscribe(function (resposta) { return _this.listaOrganizacao = resposta; });
    };
    OrganizacaoComponent = tslib_1.__decorate([
        Component({
            selector: 'app-analise',
            templateUrl: './organizacao.component.html',
            styleUrls: ['./organizacao.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [OrganizacaoService])
    ], OrganizacaoComponent);
    return OrganizacaoComponent;
}());
export { OrganizacaoComponent };
//# sourceMappingURL=organizacao.component.js.map