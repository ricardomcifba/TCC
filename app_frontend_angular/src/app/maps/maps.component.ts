import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { VazamentoService } from './maps.service';
import { forEach } from '@angular/router/src/utils/collection';

declare const google: any;

declare var MarkerClusterer: any;

/* declare var map;
declare var opt_markers;
declare var opt_options;
new MarkerClusterer(map, opt_markers, opt_options); 
 */
interface Marker {
solicitacao: number;
lat: string;
lng: string;
}
@Component({
  selector: 'app-maps',
  templateUrl: './maps.component.html',
  styleUrls: ['./maps.component.css']
})
export class MapsComponent implements OnInit {

  vazamentoAnalises: Array<any>;
  vazamento: any;
  solicitacao;
  lat;
  long;

  constructor(private service: VazamentoService) {}



  ngOnInit() {

    this.service.listar().subscribe(resposta => {
        this.solicitacao = resposta['registros'].map(resposta => resposta.numerosolicitacao)
        this.lat = resposta['registros'].map(resposta => resposta.latitude)
        this.long = resposta['registros'].map(resposta => resposta.longitude)
        console.log(this.solicitacao,this.lat,this.long)
        //marker.solicitacao = this.solicitacao
        //marker.lat = this.lat
        //marker.lng = this.long
        //console.log(marker)

    });
    
    var myLatlng = new google.maps.LatLng(-12.9665727, -38.4639189);
    //var myLatlng = new google.maps.LatLng(this.vazamento.latitude, this.vazamento.latitude);
    var mapOptions = {
        zoom: 13,
        center: myLatlng,
        scrollwheel: false, //we disable de scroll over the map, it is a really annoing when you scroll through page
         

    };
    var map = new google.maps.Map(document.getElementById("map"), mapOptions);

    var marker = new google.maps.Marker({
        position: myLatlng,
        title: "Centro do Mapa"
    });

    // To add the marker to the map, call setMap();
    marker.setMap(map);
  }



}
