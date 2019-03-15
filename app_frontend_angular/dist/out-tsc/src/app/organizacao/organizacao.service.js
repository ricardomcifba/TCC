import * as tslib_1 from "tslib";
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
var OrganizacaoService = /** @class */ (function () {
    function OrganizacaoService(http) {
        this.http = http;
        this.organizacaoUrl = 'http://localhost:8080/org';
        this.organizacaoListagemUrl = 'http://localhost:8080/org/listorg';
    }
    OrganizacaoService.prototype.listar = function () {
        return this.http.get(this.organizacaoListagemUrl);
    };
    OrganizacaoService.prototype.criar = function (organizacao) {
        return this.http.post(this.organizacaoUrl, organizacao);
    };
    OrganizacaoService = tslib_1.__decorate([
        Injectable({
            providedIn: 'root'
        }),
        tslib_1.__metadata("design:paramtypes", [HttpClient])
    ], OrganizacaoService);
    return OrganizacaoService;
}());
export { OrganizacaoService };
//# sourceMappingURL=organizacao.service.js.map