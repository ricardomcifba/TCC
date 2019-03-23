import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { MapaService } from './mapa.service';
var MapaComponent = /** @class */ (function () {
    function MapaComponent(service) {
        this.service = service;
    }
    MapaComponent.prototype.ngOnInit = function () {
        this.service.listar().subscribe(function (resposta) {
            var latitude = resposta['registros'].map(function (resposta) { return resposta.latitude; });
            var longitude = resposta['registros'].map(function (resposta) { return resposta.longitude; });
            var solicitacao = resposta['registros'].map(function (resposta) { return resposta.numerosolicitacao; });
            var perdaA = resposta['registros'].map(function (resposta) { return resposta.perdaA; });
            //var markers = [];
            var data = [];
            //Contagem dos pontos no mapa   
            //for(let i = 0; i< Object.keys(latitude).length;i++)
            for (var i = 0; i < 1500; i++) {
                //console.log(i)
                var myLatlng = new google.maps.LatLng(latitude[i], longitude[i]);
                data.push(myLatlng);
                var mapOptions = {
                    zoom: 13,
                    center: myLatlng,
                    scrollwheel: true,
                    mapTypeId: google.maps.MapTypeId.HYBRID
                };
                var map = new google.maps.Map(document.getElementById("map"), mapOptions);
                //this.contatenar = solicitacao.concat("perda de".concat(perdaA))
                var marker = new google.maps.Marker({
                    position: myLatlng,
                });
                //markers.push(marker);
                //Para adicionar marker no mapa
                //marker.setMap(map);
            }
            //Para mapa de calor
            var heatmap = new google.maps.visualization.HeatmapLayer({
                data: data
            });
            heatmap.setMap(map);
            //var markerCluster = new MarkerClusterer(map, markers, { imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m' });
        });
    };
    MapaComponent = tslib_1.__decorate([
        Component({
            selector: 'app-mapa',
            templateUrl: './mapa.component.html',
            styleUrls: ['./mapa.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [MapaService])
    ], MapaComponent);
    return MapaComponent;
}());
export { MapaComponent };
//# sourceMappingURL=mapa.component.js.map