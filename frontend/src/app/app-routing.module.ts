import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActionComponent } from './action/action.component';
import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { MainComponent } from './main/main.component';
import { NavigationComponent } from './navigation/navigation.component';

const routes: Routes = [
  {path: "", component: MainComponent},
  { path: '**', redirectTo: '', pathMatch: 'full' },
  {path: "footer", component:FooterComponent},
  {path: "action", component: ActionComponent},
  {path: "navigation", component: NavigationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
