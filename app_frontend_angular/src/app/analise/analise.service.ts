import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AnaliseService {

  analiseUrl = 'http://localhost:8080/analise';
  analiseListagemUrl = 'http://localhost:8080/analise/listagem';

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Array<any>>(this.analiseListagemUrl);
  }

  criar(analise: any) {
    return this.http.post(this.analiseUrl, analise);
  }
  
}
