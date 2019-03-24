import { Component, OnInit } from '@angular/core';
import { FatoService } from './fato.service';
import { PagerService } from '../../service';


@Component({
  selector: 'app-fato',
  templateUrl: './fato.component.html',
  styleUrls: ['./fato.component.css']
})
export class FatoComponent implements OnInit {

  listaFato: Array<any>;

  constructor(private service: FatoService, private pagerService: PagerService) { }

  // pagina
  pager: any = {};
  // itens paginados
  pagedItems: any[];

  ngOnInit() {
    this.service.listar().subscribe(resposta => {
      this.listaFato = resposta
      // iniciando da pagina 1
      this.setPage(1)
    });
  }

  setPage(page: number) {
    // objetos da pagina corrente
    this.pager = this.pagerService.getPager(this.listaFato.length, page);
    // pegar página atual
    this.pagedItems = this.listaFato.slice(this.pager.startIndex, this.pager.endIndex + 1);
  }

  download() {
    var csvData = this.gerarTXT(this.listaFato);
    var a = document.createElement("a");
    a.setAttribute('style', 'display:none;');
    document.body.appendChild(a);
    var blob = new Blob([csvData], { type: 'text/txt' });
    var url = window.URL.createObjectURL(blob);
    a.href = url;
    a.download = 'nome_do_arquivo.txt';/* your file name*/
    a.click();
    return 'success';
  }

  gerarTXT(objArray) {
    var array = typeof objArray != 'object' ? JSON.parse(objArray) : objArray;
    var str = '';
    var row = "";

    for (var index in objArray[0]) {
      //Now convert each value to string and comma-separated
      row += index + ';';
    }
    row = row.slice(0, -1);
    //append Label row with line break
    str += row + '\r\n';

    for (var i = 0; i < array.length; i++) {
      var line = '';
      for (var index in array[i]) {
        if (line != '') line += ';'

        line += array[i][index];
      }
      str += line + '\r\n';
    }
    return str;
  }

}

