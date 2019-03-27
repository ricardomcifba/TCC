import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class MapaService {
  FatoUrl = 'http://EMB641C6765D718:8080/consulta/fatoMapa';
  mapaUrl = 'http://EMB641C6765D718:8080/vazamento/listmap';

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get(this.mapaUrl).map(resp => resp);
  }

  listarFato() {
    return this.http.get(this.FatoUrl).map(resp => resp);
  };
}
