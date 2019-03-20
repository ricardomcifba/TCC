import { Routes } from '@angular/router';

import { DashboardComponent } from '../../dashboard/dashboard.component';
import { MapaComponent } from '../../mapa/mapa.component';
import { OrganizacaoComponent } from '../../organizacao/organizacao.component';
import { VazamentoComponent } from '../../vazamento/vazamento.component';
import { TableListComponent } from '../../table-list/table-list.component';
import { BairroComponent } from '../../bairro/bairro.component';
import { MapsComponent } from '../../maps/maps.component';
import { SetorComponent } from '../../setor/setor.component';
import { FatoComponent } from '../../fato/fato.component';


export const AdminLayoutRoutes: Routes = [
    { path: 'dashboard',      component: DashboardComponent },
    { path: 'maps',           component: MapsComponent },
    { path: 'table-list',     component: TableListComponent },
    { path: 'mapa',        component: MapaComponent },
    { path: 'organizacao',        component: OrganizacaoComponent },
    { path: 'vazamento',        component: VazamentoComponent },
    { path: 'bairro',        component: BairroComponent },
    { path: 'setor',        component: SetorComponent },
    { path: 'fato',        component: FatoComponent }

];
