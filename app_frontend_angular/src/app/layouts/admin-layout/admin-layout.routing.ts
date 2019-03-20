import { Routes } from '@angular/router';

import { PerdasComponent } from '../../perdas/perdas.component';
import { MapaComponent } from '../../mapa/mapa.component';
import { OrganizacaoComponent } from '../../organizacao/organizacao.component';
import { VazamentoComponent } from '../../vazamento/vazamento.component';
import { BairroComponent } from '../../bairro/bairro.component';
import { MapsComponent } from '../../maps/maps.component';
import { SetorComponent } from '../../setor/setor.component';
import { FatoComponent } from '../../fato/fato.component';


export const AdminLayoutRoutes: Routes = [
    { path: 'perdas',      component: PerdasComponent },
    { path: 'maps',           component: MapsComponent },
    { path: 'mapa',        component: MapaComponent },
    { path: 'organizacao',        component: OrganizacaoComponent },
    { path: 'vazamento',        component: VazamentoComponent },
    { path: 'bairro',        component: BairroComponent },
    { path: 'setor',        component: SetorComponent },
    { path: 'fato',        component: FatoComponent }

];
