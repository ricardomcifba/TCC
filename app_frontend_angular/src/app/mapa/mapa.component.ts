import { Component, OnInit } from '@angular/core';
import { MapaService } from './mapa.service';
import { } from 'googlemaps';

declare var MarkerClusterer: any;

@Component({
  selector: 'app-mapa',
  templateUrl: './mapa.component.html',
  styleUrls: ['./mapa.component.css']
})

export class MapaComponent implements OnInit {

  constructor(private service: MapaService) { }

  ngOnInit() {

    this.service.listarFato().subscribe(resposta => {
      let latitude = resposta['registros'].map(resposta => resposta.latitude)
      let longitude = resposta['registros'].map(resposta => resposta.longitude)

      let perdaA = resposta['registros'].map(resposta => resposta.perdaA)


      var markers = [];
      
      //for(let i = 0; i< Object.keys(latitude).length;i++){
      for (let i = 0; i < 120; i++) {
        //console.log(i)
        var myLatlng = new google.maps.LatLng(latitude[i], longitude[i]);
        //data.push(myLatlng);
        var mapOptions = {
          zoom: 13,
          center: myLatlng,
          scrollwheel: true, //Scroll do mouse habilitado
          mapTypeId: google.maps.MapTypeId.HYBRID

        };
        var map = new google.maps.Map(document.getElementById("map"), mapOptions);
        //this.contatenar = solicitacao.concat("perda de".concat(perdaA))
        var marker = new google.maps.Marker({
          position: myLatlng,
          title: ""//solicitacao[0].toString()
        });

        markers.push(marker);

        //Para adicionar marker no mapa
        //marker.setMap(map);
      }

      //Para mapa de calor
      //var heatmap = new google.maps.visualization.HeatmapLayer({
      //  data: data
      //});
      //heatmap.setMap(map);
      for (let i = 0; i < Object.keys(markers).length; i++)
        markers[i].setMap(map);
    });
  }

  cluster() {
    this.service.listarFato().subscribe(resposta => {
      let latitude = resposta['registros'].map(resposta => resposta.latitude)
      let longitude = resposta['registros'].map(resposta => resposta.longitude)

      let perdaA = resposta['registros'].map(resposta => resposta.perdaA)


      var markers = [];
      //for(let i = 0; i< Object.keys(latitude).length;i++){
      for (let i = 0; i < 120; i++) {
        var myLatlng = new google.maps.LatLng(latitude[i], longitude[i]);
        var mapOptions = {
          zoom: 13,
          center: myLatlng,
          scrollwheel: true, //Scroll do mouse habilitado
          mapTypeId: google.maps.MapTypeId.HYBRID

        };
        var map = new google.maps.Map(document.getElementById("map"), mapOptions);
        var marker = new google.maps.Marker({
          position: myLatlng,
          title: ""//solicitacao[0].toString()
        });

        markers.push(marker);

      }

      var markerCluster = new MarkerClusterer(map, markers, { imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m' });

    });
  }

  heatMap() {

    this.service.listarFato().subscribe(resposta => {
      let latitude = resposta['registros'].map(resposta => resposta.latitude)
      let longitude = resposta['registros'].map(resposta => resposta.longitude)

      var data = [];
      //for(let i = 0; i< Object.keys(latitude).length;i++){
      for (let i = 0; i < 120; i++) {
        var myLatlng = new google.maps.LatLng(latitude[i], longitude[i]);
        data.push(myLatlng);
        var mapOptions = {
          zoom: 13,
          center: myLatlng,
          scrollwheel: true, //Scroll do mouse habilitado
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map"), mapOptions);
        //this.contatenar = solicitacao.concat("perda de".concat(perdaA))
        var marker = new google.maps.Marker({
          position: myLatlng,
          title: ""//solicitacao[0].toString()
        });

      
        //Para adicionar marker no mapa
        //marker.setMap(map);
      }

      //Para mapa de calor
      var heatmap = new google.maps.visualization.HeatmapLayer({
        data: data
      });
      heatmap.setMap(map);
      
    });

  }
}


