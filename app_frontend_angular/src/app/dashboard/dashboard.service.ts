import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable'
import { ITempo } from './tempoOr'
import 'rxjs/add/operator/map';

@Injectable({
  providedIn: 'root'
})
export class FatoService {
  static listTempo(): any {
    throw new Error("Method not implemented.");
  }

  meses;
  perdas;

  FatoUrl = 'http://localhost:8080/consulta/fatodim';
  TempoUrl = 'http://localhost:8080/consulta/tempo';

  constructor(private http: HttpClient) { }

  listarFato() {
    return this.http.get<Array<Location>>(this.FatoUrl);
  }

  listarTempo() {
    return this.http.get(this.TempoUrl).map(res => res);
  }

  listTempo(): Observable<ITempo[]>{
    
    
    //this.listarTempo().subscribe(resposta => {
      
      //this.meses = resposta['meses'].map(resposta => resposta.nomeMes);
      //this.perdas = resposta['meses'].map(resposta => resposta.perdaA);
      //console.log(this.meses)
      //return this.meses;
    //})
    return this.http.get<ITempo[]>(this.TempoUrl);

    

  }

}



