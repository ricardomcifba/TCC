import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { FatoService } from './fato.service';
import { PagerService } from '../../service';
var FatoComponent = /** @class */ (function () {
    function FatoComponent(service, pagerService) {
        this.service = service;
        this.pagerService = pagerService;
        // pagina
        this.pager = {};
    }
    FatoComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.service.listar().subscribe(function (resposta) {
            _this.listaFato = resposta;
            // iniciando da pagina 1
            _this.setPage(1);
        });
    };
    FatoComponent.prototype.setPage = function (page) {
        // objetos da pagina corrente
        this.pager = this.pagerService.getPager(this.listaFato.length, page);
        // pegar página atual
        this.pagedItems = this.listaFato.slice(this.pager.startIndex, this.pager.endIndex + 1);
    };
    FatoComponent.prototype.download = function () {
        var csvData = this.ConvertToCSV(this.listaFato);
        var a = document.createElement("a");
        a.setAttribute('style', 'display:none;');
        document.body.appendChild(a);
        var blob = new Blob([csvData], { type: 'text/txt' });
        var url = window.URL.createObjectURL(blob);
        a.href = url;
        a.download = 'nome_do_arquivo.txt'; /* your file name*/
        a.click();
        return 'success';
    };
    FatoComponent.prototype.ConvertToCSV = function (objArray) {
        var array = typeof objArray != 'object' ? JSON.parse(objArray) : objArray;
        var str = '';
        var row = "";
        for (var index in objArray[0]) {
            //Now convert each value to string and comma-separated
            row += index + ';';
        }
        row = row.slice(0, -1);
        //append Label row with line break
        str += row + '\r\n';
        for (var i = 0; i < array.length; i++) {
            var line = '';
            for (var index in array[i]) {
                if (line != '')
                    line += ';';
                line += array[i][index];
            }
            str += line + '\r\n';
        }
        return str;
    };
    var _a;
    FatoComponent = tslib_1.__decorate([
        Component({
            selector: 'app-fato',
            templateUrl: './fato.component.html',
            styleUrls: ['./fato.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [FatoService, typeof (_a = typeof PagerService !== "undefined" && PagerService) === "function" ? _a : Object])
    ], FatoComponent);
    return FatoComponent;
}());
export { FatoComponent };
//# sourceMappingURL=fato.component.js.map