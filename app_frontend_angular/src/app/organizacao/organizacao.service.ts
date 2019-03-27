import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OrganizacaoService {

  organizacaoListagemUrl = 'http://EMB641C6765D718:8080/org/listorg';

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Array<any>>(this.organizacaoListagemUrl);
  }

}
