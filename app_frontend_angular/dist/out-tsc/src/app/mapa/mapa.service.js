import * as tslib_1 from "tslib";
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
var MapaService = /** @class */ (function () {
    function MapaService(http) {
        this.http = http;
        this.mapaUrl = 'http://localhost:8080/vazamento/listmap';
    }
    MapaService.prototype.listar = function () {
        return this.http.get(this.mapaUrl).map(function (resp) { return resp; });
    };
    MapaService = tslib_1.__decorate([
        Injectable({
            providedIn: 'root'
        }),
        tslib_1.__metadata("design:paramtypes", [HttpClient])
    ], MapaService);
    return MapaService;
}());
export { MapaService };
//# sourceMappingURL=mapa.service.js.map