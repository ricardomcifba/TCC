import { Component, OnInit } from '@angular/core';
import { MapaService } from './mapa.service';
import { forEach } from '@angular/router/src/utils/collection';
import {} from 'googlemaps';


@Component({
  selector: 'app-mapa',
  templateUrl: './mapa.component.html',
  styleUrls: ['./mapa.component.css']
})


export class MapaComponent implements OnInit {


  constructor(private service: MapaService) {}



  ngOnInit() {

    this.service.listar().subscribe(resposta => {
      
        //let solicitacao = resposta['registros'].map(resposta => resposta.numerosolicitacao)
        let latitude = resposta['registros'].map(resposta => resposta.latitude)
        let longitude = resposta['registros'].map(resposta => resposta.longitude)
            
        var myLatlng = new google.maps.LatLng(latitude, longitude);
          
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
  });



}
}
