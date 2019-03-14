import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VazamentoService {

  analiseVazamentoUrl = 'http://localhost:8080/vazamento/listvaz';

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get(this.analiseVazamentoUrl).map(resp => resp);
  }

}
