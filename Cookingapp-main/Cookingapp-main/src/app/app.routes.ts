import { Routes } from '@angular/router';
import { BudgetComponent } from './budget/budget.component';
import { ReceipeComponent } from './receipe/receipe.component';

export const routes: Routes = [
  { path: 'budget', component: BudgetComponent },
  { path: 'reciepe', component: ReceipeComponent },

  { path: '', redirectTo: '/budget', pathMatch: 'full' },
];

