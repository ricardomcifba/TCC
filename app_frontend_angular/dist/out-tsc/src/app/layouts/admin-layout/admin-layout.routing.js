import { DashboardComponent } from '../../dashboard/dashboard.component';
import { AnaliseComponent } from '../../analise/analise.component';
import { OrganizacaoComponent } from '../../organizacao/organizacao.component';
import { VazamentoComponent } from '../../vazamento/vazamento.component';
import { TableListComponent } from '../../table-list/table-list.component';
import { MapsComponent } from '../../maps/maps.component';
export var AdminLayoutRoutes = [
    { path: 'dashboard', component: DashboardComponent },
    { path: 'maps', component: MapsComponent },
    { path: 'table-list', component: TableListComponent },
    { path: 'analise', component: AnaliseComponent },
    { path: 'organizacao', component: OrganizacaoComponent },
    { path: 'vazamento', component: VazamentoComponent }
];
//# sourceMappingURL=admin-layout.routing.js.map