import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OrganizacaoService {

  organizacaoListagemUrl = 'http://localhost:8080/org/listorg';

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Array<any>>(this.organizacaoListagemUrl);
  }

}
