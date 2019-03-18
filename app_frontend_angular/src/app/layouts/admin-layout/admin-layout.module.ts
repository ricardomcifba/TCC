import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminLayoutRoutes } from './admin-layout.routing';
import { DashboardComponent } from '../../dashboard/dashboard.component';
//import { AnaliseComponent } from '../../analise/analise.component';
import { OrganizacaoComponent } from '../../organizacao/organizacao.component';
import { VazamentoComponent } from '../../vazamento/vazamento.component';
import { BairroComponent } from '../../bairro/bairro.component';
import { SetorComponent } from '../../setor/setor.component';
import { FatoComponent } from '../../fato/fato.component';
import { TableListComponent } from '../../table-list/table-list.component';
import { MapsComponent } from '../../maps/maps.component';
import { ChartsModule } from 'ng2-charts';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ToastrModule } from 'ngx-toastr';


@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    ChartsModule,
    NgbModule,
    ToastrModule.forRoot()
  ],
  declarations: [
    DashboardComponent,
    OrganizacaoComponent,
    //AnaliseComponent,
    TableListComponent,
    VazamentoComponent,
    MapsComponent,
    BairroComponent,
    SetorComponent,
    FatoComponent
  ]
})

export class AdminLayoutModule {}
