import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { VazamentoService } from './vazamento.service';
var VazamentoComponent = /** @class */ (function () {
    function VazamentoComponent(service) {
        this.service = service;
    }
    VazamentoComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.vazamento = {};
        this.service.listar().subscribe(function (resposta) { return _this.listaVazamento = resposta; });
    };
    VazamentoComponent = tslib_1.__decorate([
        Component({
            selector: 'app-vazamento',
            templateUrl: './vazamento.component.html',
            styleUrls: ['./vazamento.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [VazamentoService])
    ], VazamentoComponent);
    return VazamentoComponent;
}());
export { VazamentoComponent };
//# sourceMappingURL=vazamento.component.js.map