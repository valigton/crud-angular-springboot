import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmpresasComponent } from './empresas/empresas.component';
import { NovaEmpresaComponent } from './nova-empresa/nova-empresa.component';

const routes: Routes = [
  { path: '', component: EmpresasComponent },
  { path: 'cadastrar', component: NovaEmpresaComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
