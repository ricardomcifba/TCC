import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FatoService {


  analiseListagemUrl = 'http://localhost:8080/analise/listagem';

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get(this.analiseListagemUrl).map(res => res);;
  }
  
}
