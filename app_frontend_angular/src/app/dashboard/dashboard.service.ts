import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FatoService {

  FatoUrl = 'http://localhost:8080/consulta/fatodim';
  TempoUrl = 'http://localhost:8080/consulta/tempo';

  constructor(private http: HttpClient) { }

  listarFato() {
    return this.http.get<Array<Location>>(this.FatoUrl);
  }

  listarTempo() {
    return this.http.get<Array<Location>>(this.TempoUrl);
  }


}
