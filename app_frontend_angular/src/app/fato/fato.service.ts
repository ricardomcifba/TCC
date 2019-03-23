import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FatoService {

  analiseListagemUrl = 'http://localhost:8080/consulta/fatodim';

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Array<any>>(this.analiseListagemUrl);
  };

}
